/**
 * 
 */
package xyz.alamitaha.www.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.alamitaha.www.business.Product;
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

	@Override
	public Collection<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}

}
