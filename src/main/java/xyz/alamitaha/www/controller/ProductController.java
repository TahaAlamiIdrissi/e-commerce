/**
 * 
 */
package xyz.alamitaha.www.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xyz.alamitaha.www.business.Product;
import xyz.alamitaha.www.service.ProductService;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@RestController
@RequestMapping("/api/v1/product/")
@AllArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("products")
	public ResponseEntity<Collection<Product>> getAllProducts(){
		return new ResponseEntity<Collection<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}
}
