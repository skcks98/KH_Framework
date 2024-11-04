package edu.kh.todo.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.todo.dto.Todo;

public interface TodoService {

	
	/**(Test) todoNo 가 1인 할 일 제목 조회
	 * @return 
	 * 
	 */
	String testTitle();
	
	

	/** 할 일 목록 + 완료된 할 일 갯수 조회
	 * @return map
	 */
	Map<String, Object> selectAll();



	/** 할 일 추가
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 */
	int addTodo(String todoTitle, String todoContent);



	/** 할 일 상세정보
	 * @param todoNo
	 * @return
	 */
	Todo todoDetail(int todoNo);



	/** 완료 여부 변경
	 * @param todo
	 * @return todo
	 */
	int changeComplete(Todo todo);



	/** 상세정보 수정
	 * @param todo
	 * @return
	 */
	int updateDetail(Todo todo);



	
	
	/** 상세정보 삭제
	 * @param todo
	 * @return
	 */
	int deleteDetail(Todo todo);


	/** 전체 할일 개수 조회
	 * @return
	 */
	int getTotalCount();



	/** 완료된 할일 개수 조회
	 * @return
	 */
	int getCompleteCount();



	



	/** 할일 목록 조회
	 * @return
	 */
	List<Todo> selectList();



	/** 할일 삭제
	 * @param todoNo
	 * @return
	 */
	int todoDelete(int todoNo);




	
	

}
