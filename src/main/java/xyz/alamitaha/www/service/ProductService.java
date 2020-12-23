package xyz.alamitaha.www.service;

import java.util.Collection;

import xyz.alamitaha.www.business.Comment;
import xyz.alamitaha.www.business.Product;

public interface ProductService {
	
	Collection<Product> getAllProducts();
	Product getProductById(Long id);
	Product addProduct(Product product);
	boolean removeCommentFromProduct(Product product, Long commentId);
}
