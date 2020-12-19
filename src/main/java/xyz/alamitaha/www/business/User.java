/**
 * 
 */
package xyz.alamitaha.www.business;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Username should not be empty")
	private String username;
	@Email
//	@NotEmpty(message = "Email should not be empty")
	private String email;
	private String password;
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	@ToString.Exclude
	private Set<Product> products;
	
	public User() {
		this.products = new HashSet<Product>();
	}
}
