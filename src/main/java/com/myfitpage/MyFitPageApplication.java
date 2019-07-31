package com.myfitpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableConfigurationProperties
@PropertySources({
    @PropertySource(value = "file:${appConf}", ignoreResourceNotFound = true)
})

@SpringBootApplication //(exclude = { SecurityAutoConfiguration.class })
public class MyFitPageApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyFitPageApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(MyFitPageApplication.class);
    }
}
