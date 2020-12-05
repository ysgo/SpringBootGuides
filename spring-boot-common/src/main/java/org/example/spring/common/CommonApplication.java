package org.example.spring.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CommonApplication {
  public static void main(String[] args) {
    SpringApplication.run(CommonApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");
//      String[] beanNames = applicationContext.getBeanDefinitionNames();
//      Arrays.sort(beanNames);
//      for(String beanName : beanNames) {
//        System.out.println(beanName);
//      }
//      Arrays.stream(beanNames).sorted().forEach(System.out::println);
    };
  }
}
