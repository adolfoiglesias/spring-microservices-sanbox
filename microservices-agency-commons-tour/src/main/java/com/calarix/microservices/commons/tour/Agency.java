/**
 * 
 */
package com.calarix.microservices.commons.tour;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

/**
 * @author amich
 *
 */

@Data
@Entity
public class Agency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@NotNull
	public String name;
	
	@NotNull
	public String email;
	
	

}
