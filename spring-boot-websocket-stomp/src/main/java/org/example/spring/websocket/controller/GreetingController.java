package org.example.spring.websocket.controller;

import org.example.spring.websocket.model.Greeting;
import org.example.spring.websocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

  @GetMapping("/websocket")
  public String index() {
    return "index";
  }

  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage helloMessage) throws Exception {
    Thread.sleep(1000);
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
  }
}
