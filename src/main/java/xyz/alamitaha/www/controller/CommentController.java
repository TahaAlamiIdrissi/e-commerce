/**
 * 
 */
package xyz.alamitaha.www.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import xyz.alamitaha.www.business.Comment;
import xyz.alamitaha.www.service.CommentService;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@RestController
@RequestMapping("/api/v1/comment/")
@AllArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@GetMapping("index")
	public String index() {
		return "index";
	}

	@GetMapping("comments/{id}")
	public ResponseEntity<Collection<Comment>> getCommentsByProductId(@PathVariable Long id) {
		return new ResponseEntity<Collection<Comment>>(commentService.getCommentsByProduct(id), HttpStatus.OK);
	}
	
	@GetMapping("comments")
	public ResponseEntity<Collection<Comment>> getAllComments(){
		return new ResponseEntity<Collection<Comment>>(commentService.getAllComments(), HttpStatus.OK);
	}

	@PostMapping("comments/{productId}")
	public ResponseEntity<Comment> addCommentToProduct(@PathVariable Long productId, @RequestBody Comment comment) {
		return new ResponseEntity<Comment>(commentService.addComment(productId, comment), HttpStatus.CREATED);
	}
	
	@DeleteMapping("comments/{commentId}")
	public ResponseEntity<Comment> deleteComment(@PathVariable Long commentId) {
		return new ResponseEntity<Comment>(commentService.deleteComment(commentId), HttpStatus.OK);
	}
}
