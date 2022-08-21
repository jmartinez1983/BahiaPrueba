package com.prueba.bahia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BahiaApplication {

	/**
	 * @author: Jose Antonio Martinez Gonzalez
	 *
	 * Para hacer el ejercicio he usado Java 11, Maven, lombok para las anotaciones, mapstruts para el mapeo
	 * de clases, openFeign para la llamada a los servicios externos con el circuitbreaker activado para hacer
	 * al endpoint resiliente a posibles fallos en los llamadas, para la creación de los clases del api desde
	 * el yaml proporcionado he usado el plugin openapi-generator-maven-plugin.
	 *
	 * He creado un controller que llama al servicio de producto que hace la lógica, he creado el bean ProductDetails
	 * para usarlo en la parte de negocio y unos mappers para desacoplarlo del objeto del api.
	 *
	 * He activado la resiliencia en openFeign y creado una clase para el fallBack, en este caso devuelve un null si
	 * da fallo al llamar al servicio de producto, despues con el .filter en las lambdas quitamos estos nulos para que
	 * se devuelvan solo los que han ido bien. No mando ningún error ya que en el contrato no he visto ninguna definición
	 * para los errores de haberlo habido hubiera usado un @ControllerAdvice para la gestion de excepciones
	 *
	 * PROBLEMAS
	 * No he podido lanzar los test ya que me da el siguiente error al lanzarlos: "The moduleSpecifier "scripts/test.js"
	 * couldn't be found on local disk". Lo he probado manualmente y funciona bien, con la excepción de los productos
	 * con delay que están haciendo que el circuit breaker se habrá y salte el fallback. He puesto un timeout de 60s en el
	 * properties y he creado un TimeLimitter en el FeignConfiguration pero nada. Seguro que es algún detalle pequeño
	 * pero no me ha dado tiempo a mirarlo más
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BahiaApplication.class, args);
	}
}
