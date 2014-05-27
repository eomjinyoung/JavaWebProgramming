package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping 적용
@Controller
public class LogOutController {
	
	@RequestMapping("/auth/logout.do")
  public String execute(Map<String, Object> model) throws Exception {
    HttpSession session = (HttpSession)model.get("session");
    session.invalidate();
    
    return "redirect:login.do";
  }
}
