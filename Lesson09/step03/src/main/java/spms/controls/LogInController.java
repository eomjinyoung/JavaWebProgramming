package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spms.dao.MemberDao;
import spms.vo.Member;

//@Controller 애노테이션으로 변경
@Controller("/auth/login.do")
public class LogInController {
  MemberDao memberDao;
  
  @Autowired
  public LogInController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    Member loginInfo = (Member)model.get("loginInfo");
    
    if (loginInfo.getEmail() == null) { // 입력폼을 요청할 때
      return "/auth/LogInForm.jsp";
      
    } else { // 회원 등록을 요청할 때
      Member member = memberDao.exist(
          loginInfo.getEmail(), 
          loginInfo.getPassword());
      
      if (member != null) {
        HttpSession session = (HttpSession)model.get("session");
        session.setAttribute("member", member);
        return "redirect:../member/list.do";
      } else {
        return "/auth/LogInFail.jsp";
      }
    }
  }
}
