package edu.kh.project.member.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MemberMapper {

	/** 로그인 SQL 실행
	 * @param memberEmail
	 * @return
	 */
	Member login(String memberEmail);

	
	 /** 이메일 중복 검사 SQL 실행 */
	int checkEmail(String memberEmail);


	
	/** 닉네임 중복 검사 SQL 실행
	 * @param memberNickname
	 * @return
	 */
	int checkNickname(String memberNickname);


	
	/** 회원가입 SQL 실행
	 * @param inputMember
	 * @return result
	 */
	int signup(Member inputMember);


	
	/** 회원 목록 조회
	 * @return
	 */
	List<Member> getMemberList();


	
	/** 회원 비밀번호 초기화
	 * @return
	 */
	int getResetPw();


	/** 회원 탈퇴 복구
	 * @return
	 */
	int getRestorationMember();

}
