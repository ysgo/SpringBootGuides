package org.example.spring.websocket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker   // Definition: 브로커 형식의 웹 소켓 활성화
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

  @Override   // Definition: 한 클라이언트에서 다른 클라이언트로 메시지를 라우팅 하는 데 사용될 메시지 브로커를 구성
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic");   // Definition: 구독 topic 등록시 앞에 붙이는 prefix
    registry.setApplicationDestinationPrefixes("/app");        // Definition: websocket 메세지 전달시 앞에 붙이는 prefix
  }

  @Override   // Definition: 구독 topic 등록시 앞에 붙이는 prefix
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/clients").withSockJS();      // Definition: 소켓 연결 주소
  }
}
