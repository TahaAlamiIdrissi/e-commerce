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
import xyz.alamitaha.www.service.CommentService;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	private final CommentRepository commentRepository;
	private final ProductRepository productRepository;

	@Override
	public Comment addComment(Long productId,Comment comment) {
		// get product id concerned with the comment
		// add the comment to the list of comments associated with that pro
		// add comment
		Product product = productRepository.findById(productId).get();
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
	public Comment deleteComment(Long id) {
		Comment comment = commentRepository.findById(id).get();
		if(comment != null) {
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
