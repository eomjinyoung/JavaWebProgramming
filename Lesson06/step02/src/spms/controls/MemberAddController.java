package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberAddController implements Controller {
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    if (model.get("member") == null) { // 입력폼을 요청할 때
      return "/member/MemberForm.jsp";
      
    } else { // 회원 등록을 요청할 때
      MemberDao memberDao = (MemberDao)model.get("memberDao");
      
      Member member = (Member)model.get("member");
      memberDao.insert(member);
      
      return "redirect:list.do";
    }
  }
}
