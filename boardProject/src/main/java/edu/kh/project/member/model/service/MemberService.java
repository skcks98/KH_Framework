package edu.kh.project.member.model.service;

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

}
