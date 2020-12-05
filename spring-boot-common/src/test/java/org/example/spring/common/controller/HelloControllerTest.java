package org.example.spring.common.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
  @LocalServerPort
  private int port;

  private URL base;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @BeforeEach
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port + "/");
  }

  @Test
  public void getHello() throws Exception {
    ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(base.toString(), String.class);
    assertThat(responseEntity.getBody()).isEqualTo("Greeting from Spring Boot!");
  }
}
