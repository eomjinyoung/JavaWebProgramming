package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

//2. 의존 객체 주입을 위해 인스턴스 변수와 셋터 메서드 추가
//- 또한 의존 객체를 꺼내는 기존 코드 변경
public class MemberAddController02 implements Controller {
  MemberDao memberDao;
  
  public MemberAddController02 setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    if (model.get("member") == null) { // 입력폼을 요청할 때
      return "/member/MemberForm.jsp";
      
    } else { // 회원 등록을 요청할 때
      Member member = (Member)model.get("member");
      memberDao.insert(member);
      
      return "redirect:list.do";
    }
  }
}
