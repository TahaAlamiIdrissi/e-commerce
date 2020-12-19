/**
 * 
 */
package xyz.alamitaha.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.alamitaha.www.business.Product;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
