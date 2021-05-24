package com.uol.products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UolProductsApplication {
	private static final Logger LOG = LoggerFactory.getLogger(UolProductsApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(UolProductsApplication.class, args);
		LOG.info(String.join("\n", "",
				"---------------------------------------",
				" UPS - UOL Product Service Started ",
				"---------------------------------------"
		));
	}

}
