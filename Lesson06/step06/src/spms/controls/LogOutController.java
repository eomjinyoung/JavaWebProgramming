package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

public class LogOutController implements Controller {
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    HttpSession session = (HttpSession)model.get("session");
    session.invalidate();
    
    return "redirect:login.do";
  }
}
