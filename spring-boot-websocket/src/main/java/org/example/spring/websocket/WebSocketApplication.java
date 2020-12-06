package org.example.spring.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.spring")
public class WebSocketApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebSocketApplication.class, args);
  }
}
