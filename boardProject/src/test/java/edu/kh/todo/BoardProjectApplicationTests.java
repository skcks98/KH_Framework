package edu.kh.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.kh.project.BoardProjectApplication;

@SpringBootTest(classes = BoardProjectApplication.class)

// Spring Boot 테스트를 실행하기 위한 어노테이션
// 스프링 애플리케이션 컨텍스트를 로드하고, 애플리케이션의 전체 환경을 테스트 할 수 있게 해줌
class BoardProjectApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("애플리케이션 컨텍스트 로드 완료.");
	}


}
