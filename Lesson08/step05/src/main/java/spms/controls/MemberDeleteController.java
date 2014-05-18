package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.dao.MemberDao;

//스프링 애노테이션(@Component)으로 변경
@Component("/member/delete.do")
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
