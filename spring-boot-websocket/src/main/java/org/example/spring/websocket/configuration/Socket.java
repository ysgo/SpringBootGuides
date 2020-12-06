package org.example.spring.websocket.configuration;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Log
@Component
@ServerEndpoint(value = "/websocket") // Definition: 서버가 바인딩된 주소를 뜻한다.
public class Socket {
  private Session session;
  private static final Set<Socket> listeners = new CopyOnWriteArraySet<>();
  private static int onlineCount = 0;

  @OnOpen
  public void onOpen(Session session) {
    onlineCount++;
    this.session = session;
    listeners.add(this);
    log.info("onOpen called, userCount: " + onlineCount);
  }

  @OnClose // Definition: 클라이언트와 소켓과의 연결이 닫힐때 (끊길떄) 마다 호
  public void onClose(Session session) {
    onlineCount--;
    listeners.remove(this);
    log.info("onClose called, userCount:" + onlineCount);
  }

  @OnMessage // Definition: 사용자에게 메세지 전달
  public void onMessage(String message) {
    log.info("onMessage called, message:" + message);
    broadcast(message);
  }

  @OnError // Definition: 의도치 않은 에러 발생시 실행
  public void onError(Session session, Throwable throwable) {
    log.warning("onClose called, error:" + throwable.getMessage());
    listeners.remove(this);
    onlineCount--;
  }

  public static void broadcast(String message) {
    for (Socket listener : listeners) {
      listener.sendMessage(message);
    }
  }

  private void sendMessage(String message) {
    try {
      this.session.getBasicRemote().sendText(message);
    } catch (IOException e) {
      log.warning("Caught exception while sending message to Session " + this.session.getId() + "error:" + e.getMessage());
    }
  }
}
