/**
 * 
 */
package com.calarix.microservice.admin.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.calarix.microservice.admin.repository.AgencyRepository;
import com.calarix.microservice.admin.repository.CategoryRepository;
import com.calarix.microservice.admin.repository.TourRepository;
import com.calarix.microservices.commons.tour.Agency;
import com.calarix.microservices.commons.tour.Category;
import com.calarix.microservices.commons.tour.Tour;

/**
 * @author amich
 *
 */
@Configuration
public class Bootstrap implements CommandLineRunner {
	
	@Autowired
	private TourRepository tourRepository;
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		initAgency();
		initCategory();
		initTour();
	}
	
	private void initTour() {
		
		if(tourRepository.count() != 0) {
			return;
		}
		
		Category category1 = categoryRepository.findByName("Category 1");
		Category category2 = categoryRepository.findByName("Category 2");
		Category category3 = categoryRepository.findByName("Category 3");
		
		Tour tour = new Tour();
		tour.name = "Tour 1";
		tour.price = 100;
		tour.categories = new ArrayList<>();
		tour.categories.add(category1);
		tour.categories.add(category2);
		tourRepository.save(tour);
		
		tour = new Tour();
		tour.name = "Tour 2";
		tour.price = 200;
		tour.categories = new ArrayList<>();
		tour.categories.add(category1);
		tour.categories.add(category3);
		tourRepository.save(tour);
		
		tour = new Tour();
		tour.name = "Tour 3";
		tour.price = 150;
		tour.categories = new ArrayList<>();
		tour.categories.add(category3);
		tour.categories.add(category2);
		tourRepository.save(tour);
		
		tour = new Tour();
		tour.name = "Tour 4";
		tour.price = 400;
		tour.categories = new ArrayList<>();
		tour.categories.add(category1);
		tourRepository.save(tour);
	}
	

	private void initAgency() {
		
		if(agencyRepository.count() != 0) {
			return;
		}
		
		Agency agency = new Agency();
		agency.email = "agencia1@email.com";
		agency.name = "Agency";
		
		agencyRepository.save(agency);
		
	}
	
	private void initCategory() {
		
		if(categoryRepository.count() != 0) {
			return;
		}
		
		Category category = new Category();
		category.name = "Category 1";
		categoryRepository.save(category);
		
		category = new Category();
		category.name = "Category 2";
		categoryRepository.save(category);
		
		category = new Category();
		category.name = "Category 3";
		categoryRepository.save(category);
	}
	
	

}
