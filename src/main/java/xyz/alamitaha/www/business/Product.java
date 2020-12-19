/**
 * 
 */
package xyz.alamitaha.www.business;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ALAMI IDRISSI Taha
 *
 */

@Entity
@AllArgsConstructor
@Data
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "The title most be provided")
	private String title;

	@NotEmpty(message = "The description most be provided")
	@Lob
	private String description;
	private Double price;
	private Long quantity;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
	@JsonIgnore
	@ToString.Exclude
	private Set<User> users;

	

	@OneToMany(mappedBy = "product",cascade = { CascadeType.ALL }, orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private Set<Comment> comments;

	public Product() {
		this.users = new HashSet<User>();
		this.comments = new HashSet<Comment>();
	}
	public void addUsers(User user) {
		user.getProducts().add(this);
		this.users.add(user);
	}
	public void addComments(Comment comment) {
		this.comments.add(comment);
	}
}
