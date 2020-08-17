package com.calarix.microservice.oauth.security;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.calarix.microservice.oauth.services.IUserService;
import com.calarix.microservices.commons.user.User;

@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private IUserService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		
		User usuario = usuarioService.findByUsername(authentication.getName());
		info.put("nombre", usuario.getFirstName());
		info.put("apellido", usuario.getLastName());
		info.put("correo", usuario.getEmail());
		info.put("roles", usuario.getRoles()
				.stream()
				.map(r -> r.getNombre())
				.collect(Collectors.joining(","))
				);
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
