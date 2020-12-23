/**
 * 
 */
package xyz.alamitaha.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.alamitaha.www.business.User;

/**
 * @author root
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
