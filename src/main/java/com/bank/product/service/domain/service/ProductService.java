package com.bank.product.service.domain.service;


import org.springframework.stereotype.Service;

import com.bank.product.service.persistence.entity.Product;

import reactor.core.publisher.Mono;




public interface ProductService<T> extends MaintenanceService<Product>  {

	//public Mono<Product> getProductByIdProduct(String idProduct);
	

}
