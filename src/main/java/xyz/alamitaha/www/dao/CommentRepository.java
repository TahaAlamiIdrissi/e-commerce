/**
 * 
 */
package xyz.alamitaha.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.alamitaha.www.business.Comment;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
