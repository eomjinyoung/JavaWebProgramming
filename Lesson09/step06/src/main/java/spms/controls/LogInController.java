package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import spms.dao.MemberDao;
import spms.vo.Member;

//@SessionAttributes 적용
@Controller
@SessionAttributes("member")
public class LogInController {
  MemberDao memberDao;
  
  @Autowired
  public LogInController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @RequestMapping(value="/auth/login.do", method=RequestMethod.GET)
  public String loginForm() throws Exception {
      return "/auth/LogInForm.jsp";
  }
  
  @RequestMapping(value="/auth/login.do", method=RequestMethod.POST)
  public String login(
  		String email, /* 요청 파라미터 "email" */
  		String password, /* 요청 파라미터 "password" */
  		Map<String,Object> model /* 모델 객체 */) throws Exception {
    Member member = memberDao.exist(email, password);
    if (member != null) {
      model.put("member", member);
      return "redirect:../member/list.do";

    } else {
      return "/auth/LogInFail.jsp";
    }
  }
}
