package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/**	로그인
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);

	
	
	/** 이메일 중복검사 서비스
	 * @param memberEmail
	 * @return count
	 * @author 나찬웅
	 */
	int checkEmail(String memberEmail);

	
	
	
	
	/** 닉네임 중복검사 서비스 
	 * @param memberNickname
	 * @return
	 */
	int checkNickname(String memberNickname);



	/** 회원가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @return
	 */
	int signup(Member inputMember, String[] memberAddress);


	
	/** 회원 목록 조회
	 * @return
	 */
	List<Member> getMemberList();



	
	/** 회원 비밀번호 초기화
	 * @param memberNo
	 * @return
	 */
	int resetPw(int memberNo);



	/** 회원탈퇴 복구
	 * @param memberNo
	 * @return
	 */
	int resetorationMember(int memberNo);

}
