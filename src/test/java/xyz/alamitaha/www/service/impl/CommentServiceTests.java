/**
 * 
 */
package xyz.alamitaha.www.service.impl;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xyz.alamitaha.www.business.Comment;
import xyz.alamitaha.www.business.Product;
import xyz.alamitaha.www.dao.ProductRepository;
import xyz.alamitaha.www.service.CommentService;

/**
 * @author root
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceTests {

	@Autowired
	private CommentService commentService;
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddComment() {
		Comment c = new Comment();
		c.setTitle("test add comment ");
	Comment newComment = commentService.addComment(1L, c);
	Product p = productRepository.findById(1L).get();
	assertEquals(3, p.getComments().size());
	}
	
	@Test
	public void testDeleteComment() {
		Comment c = commentService.deleteComment(2L, 1L);
		Product p = productRepository.findById(1L).get();

		assertEquals(2, p.getComments().size());
	}
	
	@Test
	public void testGetAllComments() {
		assertEquals(2, commentService.getAllComments().size());
	}
	
	@Test
	public void testGetAllCommentsByProductId() {
		assertEquals(2, commentService.getCommentsByProduct(1L).size());
	}
}
