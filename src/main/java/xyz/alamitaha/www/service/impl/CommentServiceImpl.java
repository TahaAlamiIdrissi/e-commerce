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
import xyz.alamitaha.www.service.CommentService;
import xyz.alamitaha.www.service.ProductService;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	private final CommentRepository commentRepository;
	private final ProductService productService;

	@Override
	public Comment addComment(Long productId,Comment comment) {
		// get product id concerned with the comment
		// add the comment to the list of comments associated with that pro
		// add comment
		Product product = productService.getProductById(productId);
		product.addComments(comment);
		comment.setProduct(product);
		return commentRepository.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment deleteComment(Long id,Long productId) {
		Comment comment = commentRepository.findById(id).get();
		boolean isRemoved = productService.removeCommentFromProduct(productService.getProductById(productId)
				, id);
	
		
		if(comment != null && isRemoved) {
			commentRepository.delete(comment);
		}
		return comment;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Comment> getCommentsByProduct(Long id) {
		return commentRepository.findAllCommentsByProductId(id);
	}

}
