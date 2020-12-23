/**
 * 
 */
package xyz.alamitaha.www.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xyz.alamitaha.www.dao.ProductRepository;
import xyz.alamitaha.www.dao.UserRepository;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testAddProductToList() {
		User user = new Client();
		Product p = productRepository.getOne(1L);
		user.addProductToList(p);
		assertEquals(1, user.getProducts().size());
		assertEquals(1, p.getUsers().size());
	}

}
