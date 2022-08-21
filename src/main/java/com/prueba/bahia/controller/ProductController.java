package com.prueba.bahia.controller;

import com.prueba.bahia.api.ProductApi;
import com.prueba.bahia.domain.ProductDetails;
import com.prueba.bahia.mapper.ProductDetailsMapper;
import com.prueba.bahia.model.InlineResponse200;
import com.prueba.bahia.service.ProductService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

/**
 * Controlador con las operaciones sobre producto
 */
@Slf4j
@RestController
@RequestMapping(value = "/")
public class ProductController implements ProductApi {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailsMapper mapper;

    /**
     * Metodo que obtiene los detalles de los productos similares al productId pasado como parametro
     *
     * @param productId  (required) Id del producto
     * @return Set con el detalle de los productos similares a productId
     */
    @Override
    public ResponseEntity<Set<InlineResponse200>> getProductSimilar(String productId) {
        log.info("Entrada a la operacion getProductSimilar");
        Set<ProductDetails> productDetailsSet =  productService.getProductSimilar(productId);
        log.debug("Lista de productos: ".concat(String.valueOf(productDetailsSet)));
        Set<InlineResponse200> response = mapper.toApiSet(productDetailsSet);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
