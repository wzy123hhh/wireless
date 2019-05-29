package team.wireless.WebSocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/demo")
public class demo {
	
	@OnOpen
	public void open(Session session) {
		System.out.println(session.getId());
	}
	
	@OnClose
	public void close(Session session) {
		System.out.println("连接关闭");
	}
	
	@OnMessage
	public void sendMessage(Session session,String str) {
		System.out.println(str);
		
		try {
			session.getBasicRemote().sendText("hello");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
