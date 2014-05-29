package spms.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//HttpStatus 사용 
@Controller
@SessionAttributes("member")
public class LogOutController {
	
	@RequestMapping("/auth/logout.do")
  public String execute(SessionStatus status) throws Exception {
		status.setComplete();
		return "redirect:login.do";
  }
}
