package org.example.spring.common.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommonRunner {

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");
      String[] beanNames = applicationContext.getBeanDefinitionNames();
      Arrays.stream(beanNames).sorted().forEach(System.out::println);
//      Arrays.sort(beanNames);
//      for(String beanName : beanNames) {
//        System.out.println(beanName);
//      }
    };
  }
}
