package com.matomaylla.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 */
@SpringBootApplication
public class ProductApplication {
	
	/**
	 * Método principal que inicia la aplicación Spring Boot.
	 *
	 * @param args argumentos de la línea de comandos
	 */
	public static void main(final String[] args) {
	    SpringApplication.run(ProductApplication.class, args);
	}
}
