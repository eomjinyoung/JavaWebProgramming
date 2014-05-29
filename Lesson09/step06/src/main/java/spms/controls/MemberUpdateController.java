package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spms.dao.MemberDao;
import spms.vo.Member;

//@RequestParam 적용
@Controller
public class MemberUpdateController {
  MemberDao memberDao;
  
  @Autowired
  public MemberUpdateController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @RequestMapping(value="/member/update.do", method=RequestMethod.GET)
  public String updateForm(
  		int no,
  		Map<String, Object> model) throws Exception {
    Member detailInfo = memberDao.selectOne(no);
    model.put("member", detailInfo);
    return "/member/MemberUpdateForm.jsp";
  }
  
  @RequestMapping(value="/member/update.do", method=RequestMethod.POST)
  public String update(@ModelAttribute Member member) throws Exception {
    memberDao.update(member);
    return "redirect:list.do";
  }
  
  // 이 페이지 컨트롤러는 요청 파라미터 중에 날짜 형식의 데이터가 없기 때문에 
  // @InitBinder 메서드가 필요 없음
}
