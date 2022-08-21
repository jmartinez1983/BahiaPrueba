package com.prueba.bahia.service;

import com.prueba.bahia.client.ProductMocksClient;
import com.prueba.bahia.domain.ProductDetails;
import com.prueba.bahia.mapper.InlineResponse200Mapper;
import com.prueba.bahia.model.InlineResponse200;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementacion de la interfaz con las operaciones de los productos
 */
@Slf4j
@Component
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductMocksClient feignCLient;
    private InlineResponse200Mapper mapper;

    /**
     * Devuelve un set con el detalle de los productos similares a productId
     *
     * @param productId Id del producto
     * @return Set con el detalle de los productos
     */
    @Override
    public Set<ProductDetails> getProductSimilar(String productId) {
        Set<InlineResponse200> response = feignCLient.getProductSimilarids(productId).stream()
                .map(p -> feignCLient.getProduct(p.toString()))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

       return mapper.toDomainSet(response);
    }
}
