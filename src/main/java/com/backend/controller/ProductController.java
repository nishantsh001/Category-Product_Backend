package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.ProductConstant;
import com.backend.entity.ProductEntity;
import com.backend.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
//	@GetMapping
//	List<ProductEntity> getAllProductEntities(){
//		return productService.productEntities();
//	}
	
//	@GetMapping
//	public ResponseEntity<CustomPageResponse<ProductEntity>> getProducts(
//	        @RequestParam(defaultValue = "0") int pageNo, 
//	        @RequestParam(defaultValue = "2") int pageSize) {
//	    Page<ProductEntity> products = productService.getProducts(pageNo, pageSize);
//	    CustomPageResponse<ProductEntity> customResponse = new CustomPageResponse<>(products);
//	    return ResponseEntity.ok(customResponse);
//	}
	
//	@GetMapping
//	List<ProductEntity> getpProductEntities( @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "2") int pageSize){
//		return productService.productEntities(pageNo, pageSize);
//	}
	@GetMapping
	public List<ProductEntity> getProducts(
	        @RequestParam(value = "page", defaultValue = ProductConstant.page_Number) int pageNo,
	        @RequestParam(value = "size", defaultValue = ProductConstant.page_Size) int pageSize) {
	    return (List<ProductEntity>) productService.productEntities(pageNo, pageSize);
	}
	
	@GetMapping("/{id}")
	Optional<ProductEntity> getProductEntityById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping
	ProductEntity createProductEntity(@RequestBody ProductEntity productEntity) {
		return productService.createProduct(productEntity);
	}
	
//	@PostMapping
//	List<ProductEntity> creatProductEntities(@RequestBody ProductEntity productEntity){
//		return productService.productEntities();
//	}
	
	@PutMapping("/{id}")
	ProductEntity updateProductEntityById(@PathVariable Long id, @RequestBody ProductEntity productEntity) {
		return productService.updateProduct(id, productEntity);
	}
	
	@DeleteMapping("/{id}")
	void deleteProductEntityById(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
