package com.prueba.bahia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Clase con el detalle del producto
 */
@Data
@AllArgsConstructor
public class ProductDetails {

  private String id;
  private String name;
  private BigDecimal price;
  private Boolean availability;

}

