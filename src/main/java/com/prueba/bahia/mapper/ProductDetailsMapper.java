package com.prueba.bahia.mapper;

import com.prueba.bahia.domain.ProductDetails;
import com.prueba.bahia.model.InlineResponse200;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Clase encargada del mapeo del objeto producto
 */
@Component
@Mapper(componentModel="spring")
public interface ProductDetailsMapper {

    /**
     * Mapeo de la lista de productDetails a la clase del api
     *
     * @param products set con los productos
     * @return set con los objetos del api
     */
    @IterableMapping(qualifiedByName = "domainToApi")
    Set<InlineResponse200> toApiSet(Set<ProductDetails> products);

    /**
     * Mapeo del objeto product details al api
     * @param product product details
     * @return object api
     */
    @Named("domainToApi")
    InlineResponse200 toApi(ProductDetails product);
}
