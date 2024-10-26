package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.entity.ProductEntity;
import com.backend.exception.ProductNotFoundException;
import com.backend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

//	@Override
//	public Page<ProductEntity> getAllProducts(Pageable pageable) {
//		return productRepository.findAll(pageable);
//	}
	
	@Override
	public List<ProductEntity> productEntities(int pageNo, int pageSize) {
	    Page<ProductEntity> page = productRepository.findAll(PageRequest.of(pageNo, pageSize));
	    return page.getContent();  
	}
	
//	@Override
//	public Page<ProductEntity> productEntities(int pageNo, int pageSize) {
//	    PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
//	    Page<ProductEntity> pagingProduct = productRepository.findAll(pageRequest);
//	    
//	    // Debugging output
//	    System.out.println("Page Number: " + pageNo + ", Page Size: " + pageSize);
//	    pagingProduct.getContent().forEach(product -> System.out.println("Product ID: " + product.getProductId()));
//
//	    return pagingProduct;
//	}
	
//	@Override
//	public Pageable getPageable(int pageNo=0, int pageSize=2) {
//		return PageRequest.of(pageNo, pageSize);
//	}

	@Override
	public List<ProductEntity> productEntities() {
		return productRepository.findAll();
	}
	
	@Override
	public Optional<ProductEntity> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public ProductEntity createProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}
	
//	public List<ProductEntity> createProductEntities(List<ProductEntity> productEntities){
//		return productRepository.saveAll(productEntities);
//	}

	@Override
	public ProductEntity updateProduct(Long id, ProductEntity updatedProductEntity) {
		return productRepository.findById(id)
				.map(product->{
					product.setProductname(updatedProductEntity.getProductname());
					product.setProductPrice(updatedProductEntity.getProductPrice());
					return productRepository.save(product);
				}).orElseThrow(()->new ProductNotFoundException(id));
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);;
		
	}
}
