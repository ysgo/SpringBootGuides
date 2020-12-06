package org.example.spring.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.spring")
public class WebSocketStompApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebSocketStompApplication.class, args);
  }
}
