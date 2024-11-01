package edu.kh.todo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.todo.dto.Todo;
import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.mapper.TodoMapper;

// @Transactional
// - 트랜잭션 처리를 수행라라고 지기하는 어노테이녀
// 정상 코드 수행 시 COMMIT
// - 기본 값 Service 내부 코드 수행 중 Runtime Exception 발생 

// rollbackFor 속성 : 어떤 예외가 발생하였을 때 RollBack 할지

@Transactional(rollbackFor=Exception.class)
@Service	// 비즈니스 로직(데이터 가공, 트랜잭션 처리) 역할 명시 + Bean 등록
public class TodoServiceImpl implements TodoService{

	@Autowired	// TodoDAO와 같은 타입 Bean 의존성 주입(DI)
	private TodoDAO dao;
	
	@Autowired	// TodoMapper 인터페이스를 상속받은 자식 객체 의존성 주입(DI)
	private TodoMapper mapper; // 자식객체가 sqlSessionTemplate을 내부적으로 이용
	
	
	// (Test) todoNo가 1인 할 일 제목 조회
	@Override
	public String testTitle() {
		return dao.testTitle();
	}

	
	// 할 일 목록 + 완료된 할 일 갯수 조회
	@Override
	public Map<String, Object> selectAll() {
		
		// 1. 할 일 목록 조회
		List<Todo> todoList = mapper.selectAll();
		
		// 2. 완료된 할 일 개수 조회
		int completeCount = mapper.getCompleteCount();
		
		// 3. 위 두개 결과 값을 Map으로 묶어서 반환
		Map<String, Object> map = new HashMap<>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		return map;
	}


	// 할 일 추가
	@Override
	public int addTodo(String todoTitle, String todoContent) {
		
		// 트랜잭션 제어 처리 => @Transcationl 어노테이션

		
		Todo todo = new Todo();
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		
		return mapper.addTodo(todo);
	}


	// 할 일 상세정보
	@Override
	public Todo todoDetail(int todoNo) {
		
		
		return mapper.todoDetail(todoNo);
	}


	// 완료 여부 변경
	@Override
	public int changeComplete(Todo todo) {
		
		
		
		return mapper.changeComplete(todo);
	}


	// 상세정보 변경
	@Override
	public int updateDetail(Todo todo) {
		
		return mapper.updateDetail(todo);
	}


	// 상세정보 삭제
	@Override
	public int deleteDetail(Todo todo) {
		
		return mapper.deleteDetail(todo);
	}
	
}
