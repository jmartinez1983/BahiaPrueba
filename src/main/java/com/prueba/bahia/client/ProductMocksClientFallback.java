package com.prueba.bahia.client;

import com.prueba.bahia.domain.ProductDetails;
import com.prueba.bahia.model.InlineResponse200;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Clase encargada de gestionar el response de las llamadas feign en casa de error
 */
@Component
public class ProductMocksClientFallback implements ProductMocksClient {

    /**
     * Deuvelve coleccion vacia en casa de fallo
     *
     * @param productId Id del producto
     * @return vacio
     */
    @Override
    public List<Integer> getProductSimilarids(String productId) {
        return Collections.emptyList();
    }

    /**
     * Devuelve null en caso de fallo
     *
     * @param productId Id del producto
     * @return null
     */
    @Override
    public InlineResponse200 getProduct(String productId) {
        return null;
    }
}