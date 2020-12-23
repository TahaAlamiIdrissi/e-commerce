/**
 * 
 */
package xyz.alamitaha.www.business;

import javax.persistence.Entity;

import lombok.Data;

/**
 * @author ALAMI IDRISSI Taha
 *
 */
@Entity
public class Admin extends User{
	private final static boolean ADMIN = true;
}
