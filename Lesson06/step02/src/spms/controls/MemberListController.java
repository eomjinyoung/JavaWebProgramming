package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;

public class MemberListController implements Controller {
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    // Map 객체에서 MemberDao를 꺼낸다.
    MemberDao memberDao = (MemberDao)model.get("memberDao");
    
    // 회원 목록 데이터를 Map 객체에 저장한다.
    model.put("members", memberDao.selectList());
    
    // 화면을 출력할 페이지의 URL을 반환한다.
    return "/member/MemberList.jsp";
  }
}
