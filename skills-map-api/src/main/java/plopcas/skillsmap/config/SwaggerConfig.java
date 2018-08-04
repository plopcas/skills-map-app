package plopcas.skillsmap.config;

import io.swagger.jaxrs.config.BeanConfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Configuration bean to set up Swagger.
 */
@Component
public class SwaggerConfig {
    @Value("${server.hostname}")
    private String hostname;

    @Value("${server.port}")
    private String port;

    @Value("${swagger.apiVersion}")
    private String apiVersion;

    @Value("${swagger.basePath}")
    private String basePath;

    @Value("${swagger.resourcePackage}")
    private String resourcePackage;

    @Value("${swagger.schemes}")
    private String schemes;

    @PostConstruct
    public void init() {
	BeanConfig beanConfig = new BeanConfig();
	beanConfig.setVersion(apiVersion);
	beanConfig.setSchemes(new String[] { schemes });
	beanConfig.setHost(hostname + ":" + port);
	beanConfig.setBasePath(basePath);
	beanConfig.setResourcePackage(resourcePackage);
	beanConfig.setScan(true);
    }
}