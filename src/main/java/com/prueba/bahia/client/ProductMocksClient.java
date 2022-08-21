package com.prueba.bahia.client;

import com.prueba.bahia.model.InlineResponse200;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Cliente Feign con las operaciones externas sobre productos
 */
@FeignClient(value = "productMockFeign", url = "http://localhost:3001/", fallback = ProductMocksClientFallback.class)
public interface ProductMocksClient {

    /**
     * Recupera una lista de ids de productos similares al productId pasado como parametro
     *
     * @param productId Id del producto
     * @return Lista con los ids similares al productId
     */
    @RequestMapping(method = RequestMethod.GET, value = "/product/{productId}/similarids", produces = "application/json")
    List<Integer> getProductSimilarids(@PathVariable("productId") String productId);

    /**
     * Recupera los detalles del producto con id productId
     * @param productId Id del producto
     * @return Objeto con los detalles del producto con id el productId
     */
    @RequestMapping(method = RequestMethod.GET, value = "/product/{productId}", produces = "application/json")
    InlineResponse200 getProduct(@PathVariable("productId") String productId);
}