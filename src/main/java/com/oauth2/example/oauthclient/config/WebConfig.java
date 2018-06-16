package com.oauth2.example.oauthclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer handler){
		handler.enable();
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		super.addViewControllers(registry);
		registry.addViewController("/")
		.setViewName("forward:/index");
		registry.addViewController("/index");
		registry.addViewController("/secure");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}
	@Bean
	public RequestContextListener requestContextListener(){
		return new RequestContextListener();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfig(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
