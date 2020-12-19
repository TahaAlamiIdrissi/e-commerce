/**
 * 
 */
package xyz.alamitaha.www.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xyz.alamitaha.www.business.Comment;
import xyz.alamitaha.www.business.Product;
import xyz.alamitaha.www.dao.CommentRepository;
import xyz.alamitaha.www.dao.ProductRepository;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@Configuration
@Slf4j
@Component
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initTestDatabase(CommentRepository commentRepository,ProductRepository productRepository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				initDbWithProducts(productRepository);
				initDbWithComments(commentRepository, productRepository);
			}
		};
	}
	
	private void initDbWithProducts(ProductRepository productRepository) {
		Product product = Product.builder()
				.id(1L)
				.title("Test Product")
				.description("This is a description")
				.price(2D)
				.quantity(10L)
				.build();
		
	   productRepository.save(product);
	   log.info("new productsaved to DB " + product);
	}
	private void initDbWithComments(CommentRepository commentRepository,ProductRepository productRepository) {
		Comment comment = Comment.builder()
				.id(1L)
				.title("Comment")
				.content("Content")
				.build();
		comment.setProduct(productRepository.getOne(1L));
		commentRepository.save(comment);
	   log.info("new comment saved to DB " + comment);
	}

}
