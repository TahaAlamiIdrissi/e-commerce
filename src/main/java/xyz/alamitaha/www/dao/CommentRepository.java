/**
 * 
 */
package xyz.alamitaha.www.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xyz.alamitaha.www.business.Comment;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("SELECT u.comments FROM Product u WHERE u.id = ?1")
	Collection<Comment> findAllCommentsByProductId(Long id);
}
