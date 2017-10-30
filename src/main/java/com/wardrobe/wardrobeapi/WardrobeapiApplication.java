package com.wardrobe.wardrobeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WardrobeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WardrobeapiApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/clothing/add").allowedOrigins("http://localhost:3000");
				registry.addMapping("/clothing/all").allowedOrigins("http://localhost:3000");
				registry.addMapping("/clothing/update/").allowedOrigins("http://localhost:3000");
				registry.addMapping("/clothing/delete").allowedOrigins("http://localhost:3000");
			}
		};
	}
//	@Configuration
//	public class WebConfig {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**");
//            }
//        };
//    }
//}
}
