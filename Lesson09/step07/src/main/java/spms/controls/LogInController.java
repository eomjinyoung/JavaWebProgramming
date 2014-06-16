package spms.controls;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
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
  public String loginForm(
  		  @CookieValue(value="email", required=false) String email,
  		  Map<String,Object> model) throws Exception {
  	if (email != null) {
  		model.put("email",email);
  		model.put("saveEmailState", "checked");
  	}
    return "/auth/LogInForm.jsp";
  }
  
  @RequestMapping(value="/auth/login.do", method=RequestMethod.POST)
  public String login(
  		String email, /* 요청 파라미터 "email" */
  		String password, /* 요청 파라미터 "password" */
  		String saveEmail, /* 요청 파라미터 "saveEmail" */
  		HttpServletResponse response,
  		Map<String,Object> model /* 모델 객체 */) throws Exception {
  	
  	Cookie cookie = null;
  	if (saveEmail != null) {
  		cookie = new Cookie("email", email);
  		cookie.setMaxAge(60 * 60 * 24 * 365); // 365일 동안 쿠키 보관
  	} else {
  		cookie = new Cookie("email", "xxxx");
  		cookie.setMaxAge(0);
  	}
  	response.addCookie(cookie);
  	
    Member member = memberDao.exist(email, password);
    if (member != null) {
      model.put("member", member);
      return "redirect:../member/list.do";

    } else {
      return "/auth/LogInFail.jsp";
    }
  }
}
