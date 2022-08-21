package com.prueba.bahia.service;

import com.prueba.bahia.domain.ProductDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Interface con las operaciones del producto
 */
public interface ProductService {

    /**
     * Devuelve un set con el detalle de los productos similares a productId
     *
     * @param productId Id del producto
     * @return Set con el detalle de los productos
     */
    public Set<ProductDetails> getProductSimilar(String productId);
}
