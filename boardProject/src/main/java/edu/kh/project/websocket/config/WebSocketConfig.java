package edu.kh.project.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import edu.kh.project.websocket.handler.ChattingWebSocketHandler;
import edu.kh.project.websocket.handler.TestWebSocketHandler;
import lombok.RequiredArgsConstructor;

@Configuration				// 서버 실행 시 작성된 메서드를 모두 수행
@EnableWebSocket			// 웹소켓 활성화 설정
@RequiredArgsConstructor	// 필드에 final 붙이면 자동으로 autowired 주입
public class WebSocketConfig implements WebSocketConfigurer{
	
	// Bean으로 등록된 SessionHandShakeInterceptor가 주입됨
	private final HandshakeInterceptor handShakeInterceptor;
	
	// 웹소켓 처리 동작이 작성된 객체 의존성 주입
	private final TestWebSocketHandler testWebSocketHandler;
	
	// 채팅 관련 웹소켓 처리 동작이 작성된 객체 의존성 주입
	private final ChattingWebSocketHandler chattingWebsocketHandler;

	
	// 웹소켓 핸들러를 등록하는 메서드
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry
		.addHandler(testWebSocketHandler, "/testSock")
		// ws://localhost/testSock으로
		// 클라이언트가 요청을 하면
		// testWebSocketHandler가 처리하도록 등록
		.addInterceptors(handShakeInterceptor)
		// 클라이언트 연결 시 HttpSession을 가로채 핸들러에게 전달하는 handShakeInterceptor 등록
		.setAllowedOriginPatterns("http://localhost/",
								"http://127.0.1/",
								"http://192.168.50.244/")
		
		// 웹소켓 요청이 허용되는 ip/도메인 지정
		.withSockJS(); // sockJS 지원
		
		//--------------------------------------
		
		registry
		.addHandler(chattingWebsocketHandler, "/chattingSock")
		.addInterceptors(handShakeInterceptor)
		.setAllowedOriginPatterns("http://localhost/",
								"http://127.0.1/",
								"http://192.168.50.244/")
		.withSockJS(); 
		
	}
	
	
	
}