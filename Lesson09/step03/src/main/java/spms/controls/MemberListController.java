package spms.controls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spms.dao.MemberDao;

//@Controller 애노테이션으로 변경
@Controller("/member/list.do")
public class MemberListController {
  MemberDao memberDao;
  
  @Autowired
  public MemberListController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
  	HashMap<String,Object> paramMap = new HashMap<String,Object>();
  	paramMap.put("orderCond", model.get("orderCond"));
  	
    model.put("members", memberDao.selectList(paramMap));
    return "/member/MemberList.jsp";
  }
}
