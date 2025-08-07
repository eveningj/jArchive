package kr.co.iei.notice.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.iei.notice.model.dao.NoticeDao;
import kr.co.iei.notice.model.vo.NoticeListData;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	//reqPage : 사용자가 요청한 페이지 번호
	//한 페이지에 보여줄 게시물 수 (지정) : 10개
	public NoticeListData selectNoticeList(int reqPage) {
		int numPerPage = 5;
		// 쿼리문은 변경되지 않고 시작번호와 끝 번호가 변경됨.
		// 사용자가 요청한 페이지에 따라서 게시물의 시작번호와 끝 번호를 계산
		//	reqPage == 1 -> start = 1 / end = 10
		//	reqPage == 2 -> start = 2 / end = 20
		//	reqPage == 3 -> start = 3 / end = 30
		//	reqPage == 4 -> start = 4 / end = 40
		//	reqPage == 5 -> start = 5 / end = 50
		int end = reqPage * numPerPage;
		int start = end - numPerPage + 1;
		//Mybatis 에 매개변수를 전달할 때는 1개의 객체로 묶어서 전달
		//전달하고 싶은 데이터를 담을 vo 가 있으면 vo로 묶어서 전달함.
		//담을 vo 가 없으면 -> 1) vo를 생성 2)HashMap 사용
		HashMap<String, Object> param = new HashMap<String,Object>();
		param.put("start", start);
		param.put("end", end);
		
		// 페이지 네비를 제작 (사용자가 클릭해서 다른 페이지를 요청할 수 있는 요소)
		// 페이지 네비를 Service 에서 만드는 이유 -> 총 게시물 수, reqPage, numPerPage 등과 같은 데이터가 필요
		// 전체 게시물 수 조회 -> 전체 게시물 수를 알아야 numPerPage 와 연산을 통해서 총 페이지 수 계산
		
		int totalCount = noticeDao.selectNoticeTotalCount();
		System.out.println("총 게시물 수 : " +totalCount);
		//총 페이지 수 계산
		//2298588 -> 229859
		/*
		int totalPage = 0;
		if(totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		}else {
			totalPage = totalCount / numPerPage + 1;
		}
		*/
		
		/*int totalPage = totalCount / numPerPage;*/
		
		/*if(totalCount % numPerPage != 0) {
			totalPage += 1;
		}*/
		int totalPage = (int)Math.ceil(totalCount/(double)numPerPage);
		
		System.out.println("totalPage : " +totalPage);
		
		//페이지 네비게이션 길이 지정
		int pageNavSize = 10;
		
		//페이지 네비 시작 번호 지정
		//reqPage 1~5 : 1 2 3 4 5 (0~4)/5 -> 0
		//reqPage 6~10 : 6 7 8 9 10	(5~9)/5 -> 1
		//reqPage 11~15 : 11 12 13 14 15 (10~14)/5 -> 2
		int pageNo = ((reqPage-1)/pageNavSize)*pageNavSize + 1;
		
		//페이지 네비 html 을 생성.
		String pageNav = "<ul class = 'pagination circle-style'>";
		//이전버튼(1페이지로 시작하는게 아닌 경우에만 이전 버튼 생성)
		if(pageNo != 1) {
			pageNav += "<li>";
			pageNav += "<a class = 'page-item' href = '/notice/list?reqPage="+(pageNo-1)+"'>";
			pageNav += "<span class = 'material-icons'>chevron_left</span>";
			pageNav += "</a>";
			pageNav += "</li>";
		}
		//Page 이동하는 숫자 생성
		for (int i = 0; i<pageNavSize; i++) {
			pageNav += "<li style = 'width : 100px;'>";
			if(pageNo == reqPage) {
				pageNav += "<a class = 'page-item active-page' href = '/notice/list?reqPage="+pageNo+"'>";
			}else {
				pageNav += "<a class = 'page-item' href = '/notice/list?reqPage="+pageNo+"'>";
			}
			pageNav += pageNo;
			pageNav += "</a>";
			pageNav += "</li>";
			pageNo++;
			//페이징을 제작하다 마지막 페이지를 출력했으면 더이상 반복하지 않고 반복문 종료
			if(pageNo > totalPage)	{
				break;
			}
		}
		//다음 버튼 (최종 페이지를 출력하지 않은 경우)
		if(pageNo <= totalPage)	{
			pageNav += "<li>";
			pageNav += "<a class = 'page-item' href = '/notice/list?reqPage="+pageNo+"'>";
			pageNav += "<span class = 'material-icons'>chevron_right</span>";
			pageNav += "</a>";
			pageNav += "</li>";
		}
		
		pageNav += "</ul>";
		List list = noticeDao.selectNoticeList(param);
		
		//되돌려주고 싶은 데이터가 List 와 String
		//java에서 Method(함수)의 수행결과는 반드시 하나의 타입으로 리턴
		// -> 객체를 생성해서 사용(여러데이터를 하나로 묶는 객체)
		
		NoticeListData nid = new NoticeListData(list, pageNav);
		return nid;
	}
}
