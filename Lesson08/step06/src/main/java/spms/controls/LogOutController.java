package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

//@Controller 애노테이션으로 변경
@Controller("/auth/logout.do")
public class LogOutController {
  public String execute(Map<String, Object> model) throws Exception {
    HttpSession session = (HttpSession)model.get("session");
    session.invalidate();
    
    return "redirect:login.do";
  }
}
