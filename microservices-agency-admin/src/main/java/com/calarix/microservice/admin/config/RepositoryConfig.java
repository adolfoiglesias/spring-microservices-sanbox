/**
 * 
 */
package com.calarix.microservice.admin.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.calarix.microservices.commons.tour.Agency;
import com.calarix.microservices.commons.tour.Category;
import com.calarix.microservices.commons.tour.Tour;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author amich
 *
 */
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Agency.class, Tour.class, Category.class);
	}
	
	@Override
	public void configureExceptionHandlerExceptionResolver(ExceptionHandlerExceptionResolver exceptionResolver) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureExceptionHandlerExceptionResolver(exceptionResolver);
	}
	
	@Override
	public void configureConversionService(ConfigurableConversionService conversionService) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureConversionService(conversionService);
	}
	@Override
	public void configureHttpMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureHttpMessageConverters(messageConverters);
	}
	
	@Override
	public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureJacksonObjectMapper(objectMapper);
	}
	
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureValidatingRepositoryEventListener(validatingListener);
	}

}
