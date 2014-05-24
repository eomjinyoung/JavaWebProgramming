package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.dao.MemberDao;
import spms.vo.Member;

//@RequestMapping 적용
@Controller
public class MemberAddController {
  MemberDao memberDao;
  
  @Autowired
  public MemberAddController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @RequestMapping("/member/add.do")
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    if (member.getEmail() == null) { // 입력폼을 요청할 때
      return "/member/MemberForm.jsp";
    } else { // 회원 등록을 요청할 때
      memberDao.insert(member);
      return "redirect:list.do";
    }
  }
}
