package com.todcode.elasticsearch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.todcode.elasticsearch.storage.StorageProperties;
import com.todcode.elasticsearch.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class) //<- da se registruje kao Bean ona klasa gde je @ConfigurationProperties
public class ElasticsearchApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(ElasticsearchApplication.class, args);
  }
  
  //Bean for testing - integration
  @Bean
  CommandLineRunner init(StorageService storageService) {
      return (args) -> {
          storageService.deleteAll();
          storageService.init();
      };
  }
}
