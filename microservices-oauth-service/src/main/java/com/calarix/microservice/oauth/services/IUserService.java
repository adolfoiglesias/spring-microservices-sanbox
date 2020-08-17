package com.calarix.microservice.oauth.services;

import com.calarix.microservices.commons.user.User;

public interface IUserService {
	
	public User findByUsername(String username);
	
	public User update(User usuario, Long id);

}
