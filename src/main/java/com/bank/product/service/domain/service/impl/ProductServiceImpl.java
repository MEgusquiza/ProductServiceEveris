package com.bank.product.service.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.product.service.domain.repository.ProductRepository;
import com.bank.product.service.domain.service.ProductService;
import com.bank.product.service.persistence.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService<Product> {

	
	@Autowired
	private ProductRepository productRepository;
		
	@Override
	public Flux<Product> findAll() {
		return productRepository.findAll();
	
	}

	@Override
	public Mono<Product> findEntityById(String id) {
		return productRepository.findById(id);
	
	}

	@Override
	public Mono<Product> createEntity(Product entity) throws Exception {
		return productRepository.insert(entity);
	}

	@Override
	public Mono<Product> updateEntity(Product entity) {
		return productRepository.findById(entity.getId())
				 .switchIfEmpty(Mono.error(new Exception("No product found with Id: " )))
				 .flatMap(item-> productRepository.save(entity));
	}

	@Override
	public Mono<Void> deleteEntity(String id) {
		return productRepository.findById(id)
				 .switchIfEmpty(Mono.error( new Exception("No Product found with Id: ") ))
				 .flatMap(item-> productRepository.deleteById(id));
	}

	/*@Override
	public Mono<Product> getProductByIdProduct(String idProduct) {
		return productRepository.findByIdProduct(idProduct);
	}*/

}
