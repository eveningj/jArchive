package kr.co.iei.notice.model.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias(value = "notice")

public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private String regDate;
	//vo 는 꼭 컬럼과 일치할 필요는 없음 -> filelist 는 DB 에 없는 하옴ㄱ
	private List<NoticeFile> fileList;
	
	public String getNoticeContentBr() {
		return noticeContent.replaceAll("\n", "<br>");
	}
}
