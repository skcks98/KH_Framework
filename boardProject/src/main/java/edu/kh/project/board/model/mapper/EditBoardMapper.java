package edu.kh.project.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImg;

@Mapper
public interface EditBoardMapper {

	
	
	/** 게시글 작성
	 * @param inputBoard
	 * @return result
	 */
	int boardInsert(Board inputBoard);



	int insertUploadList(List<BoardImg> uploadList);
}
