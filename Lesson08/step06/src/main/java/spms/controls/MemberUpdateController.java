package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spms.dao.MemberDao;
import spms.vo.Member;

//@Controller 애노테이션으로 변경
@Controller("/member/update.do")
public class MemberUpdateController {
  MemberDao memberDao;
  
  @Autowired
  public MemberUpdateController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    
    if (member.getEmail() == null) { 
      Integer no = (Integer)model.get("no");
      Member detailInfo = memberDao.selectOne(no);
      model.put("member", detailInfo);
      return "/member/MemberUpdateForm.jsp";

    } else { 
      memberDao.update(member);
      return "redirect:list.do";
    }
  }
}
