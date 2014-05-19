package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spms.dao.MemberDao;

//@Controller 애노테이션으로 변경
@Controller("/member/delete.do")
public class MemberDeleteController {
  MemberDao memberDao;
  
  @Autowired
  public MemberDeleteController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    Integer no = (Integer)model.get("no");
    memberDao.delete(no);
    
    return "redirect:list.do";
  }
}
