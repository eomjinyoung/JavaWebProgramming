package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

//스프링 애노테이션(@Component)으로 변경
@Component("/member/add.do")
public class MemberAddController implements Controller, DataBinding {
  MemberDao memberDao;
  
  @Autowired
  public MemberAddController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "member", spms.vo.Member.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    if (member.getEmail() == null) { // 입력폼을 요청할 때
      return "/member/MemberForm.jsp";
    } else { // 회원 등록을 요청할 때
      memberDao.insert(member);
      return "redirect:list.do";
    }
  }
}
