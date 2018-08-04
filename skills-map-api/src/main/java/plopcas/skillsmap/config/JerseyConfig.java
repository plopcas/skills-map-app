package plopcas.skillsmap.config;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import plopcas.skillsmap.controller.PersonController;
import plopcas.skillsmap.controller.ProductController;
import plopcas.skillsmap.controller.ProductExperienceController;
import plopcas.skillsmap.controller.TechnologyController;
import plopcas.skillsmap.controller.TechnologyExperienceController;

/**
 * Main configuration class.
 */
@Configuration
@ComponentScan(basePackages = { "plopcas.skillsmap" })
@ApplicationPath("/api")
@EnableAsync
@EnableTransactionManagement
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
	configureSwagger();

	register(PersonController.class);
	register(ProductController.class);
	register(TechnologyController.class);
	register(ProductExperienceController.class);
	register(TechnologyExperienceController.class);
    }

    private void configureSwagger() {
	register(ApiListingResource.class);
	register(SwaggerSerializers.class);
    }
    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}