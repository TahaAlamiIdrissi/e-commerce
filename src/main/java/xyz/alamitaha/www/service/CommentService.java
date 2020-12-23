/**
 * 
 */
package xyz.alamitaha.www.service;

import java.util.Collection;

import xyz.alamitaha.www.business.Comment;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
public interface CommentService {

	//add comment
	Comment addComment(Long productId,Comment comment);
	
	// update comment
	Comment updateComment(Comment comment);
	
	//delete comment
	Comment deleteComment(Long id,Long productId);
	
	// get comments
	Collection<Comment> getAllComments();
	
	// get comments by product
	Collection<Comment> getCommentsByProduct(Long id);
}
