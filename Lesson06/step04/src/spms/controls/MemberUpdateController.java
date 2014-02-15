package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

// 의존 객체 주입을 위해 인스턴스 변수와 셋터 메서드 추가
//- 또한 의존 객체를 꺼내는 기존 코드 변경
public class MemberUpdateController implements Controller {
  MemberDao memberDao;
  
  public MemberUpdateController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    if (model.get("member") == null) { 
      Integer no = (Integer)model.get("no");
      Member member = memberDao.selectOne(no);
      model.put("member", member);
      return "/member/MemberUpdateForm.jsp";

    } else { 
      Member member = (Member)model.get("member");
      memberDao.update(member);
      return "redirect:list.do";
    }
  }
}
