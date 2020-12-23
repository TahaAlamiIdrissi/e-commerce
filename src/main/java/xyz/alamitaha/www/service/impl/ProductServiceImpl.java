/**
 * 
 */
package xyz.alamitaha.www.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.alamitaha.www.business.Comment;
import xyz.alamitaha.www.business.Product;
import xyz.alamitaha.www.dao.CommentRepository;
import xyz.alamitaha.www.dao.ProductRepository;
import xyz.alamitaha.www.service.ProductService;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final CommentRepository commentRepository;
	@Override
	@Transactional(readOnly = true)
	public Collection<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean removeCommentFromProduct(Product product, Long commentId) {
		Comment comment = commentRepository.findById(commentId).get();
		return product.getComments().remove(comment);
	}

}
