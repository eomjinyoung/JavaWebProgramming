package spms.controls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.dao.ProjectDao;

//@RequestParam의 활용
@Controller
public class ProjectListController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectListController setMemberDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }

  @RequestMapping("/project/list.do")
  public String execute(
  		/*@RequestParam String orderCond,*/
  		/*@RequestParam(required=false) String orderCond,*/
  		/*@RequestParam(value="orderCond") String orderCond,*/
  		/*@RequestParam("orderCond") String orderCond,*/
  		/*@RequestParam("orderCond") String order,*/
  		/*@RequestParam(defaultValue="ENDDATE_DESC") String orderCond,*/
  		String orderCond,
  		Map<String, Object> model) throws Exception {
  	HashMap<String,Object> paramMap = new HashMap<String,Object>();
  	paramMap.put("orderCond", orderCond);
  	
    model.put("projects", projectDao.selectList(paramMap));
    model.put("orderCond", orderCond);
    return "/project/ProjectList.jsp";
  }
}
