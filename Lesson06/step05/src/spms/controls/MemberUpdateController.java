package spms.controls;

import java.util.Map;

import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

// Map 객체에 저장할 파라미터에 대한 정보 제공
//- DataBinding 인터페이스 구현
public class MemberUpdateController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public MemberUpdateController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class,
        "member", spms.vo.Member.class
    };
  }
  
  @Override
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
