/**
 * 
 */
package com.calarix.microservices.commons.tour;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * @author amich
 *
 */

@Data
@Entity
public class Tour {
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	public String name;
	
	public double price;
	
	@ManyToMany(mappedBy = "tours", fetch = FetchType.LAZY)
	public List<Category> categories;

}
