package spms.controls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.dao.ProjectDao;

//@RequestMapping의 활용
@Controller
public class ProjectListController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectListController setMemberDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }

  //* value 속성 테스트
  @RequestMapping(value="/project/list.do")
  //*/
  /* value 속성 생략 가능
  @RequestMapping("/project/list.do")
  */
  /* method 속성 테스트
  @RequestMapping(
  		value="/project/list.do", 
  		method=RequestMethod.GET //HTTP method 지정
  )
  */
  /* params 속성 테스트 
  @RequestMapping(
  		value="/project/list.do", 
  		params="orderCond=TITLE_ASC"
  )
  */
  public String execute(
  		String orderCond,
  		Map<String, Object> model) throws Exception {
  	HashMap<String,Object> paramMap = new HashMap<String,Object>();
  	paramMap.put("orderCond", orderCond);
  	
    model.put("projects", projectDao.selectList(paramMap));
    model.put("orderCond", orderCond);
    return "/project/ProjectList.jsp";
  }
}
