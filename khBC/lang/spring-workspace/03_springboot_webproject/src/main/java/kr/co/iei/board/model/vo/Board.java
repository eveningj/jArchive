package kr.co.iei.board.model.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias(value = "board")
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardDate;
	
	private List<BoardFile> fileList;
	
	public String getBoardContentBr() {
		return boardContent.replaceAll("\n", "<br>");
	}
}
