package com.todcode.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ElasticsearchApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(ElasticsearchApplication.class, args);
  }
}
