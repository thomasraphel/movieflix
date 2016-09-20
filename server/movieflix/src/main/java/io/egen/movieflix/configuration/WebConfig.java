package io.egen.movieflix.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("io.egen.movieflix.*")  //setting the base packages to scan for configuration or beans
@EnableWebMvc                         //to understand http methods and details of servlet container and war files,locations etc
public class WebConfig {

}
