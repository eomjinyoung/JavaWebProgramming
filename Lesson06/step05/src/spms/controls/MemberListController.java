package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;

// 의존 객체 주입을 위해 인스턴스 변수와 셋터 메서드 추가
//- 또한 의존 객체를 꺼내는 기존 코드 변경
public class MemberListController implements Controller {
  MemberDao memberDao;
  
  public MemberListController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    model.put("members", memberDao.selectList());
    return "/member/MemberList.jsp";
  }
}
