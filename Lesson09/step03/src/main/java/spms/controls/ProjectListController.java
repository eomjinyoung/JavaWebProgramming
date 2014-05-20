package spms.controls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.dao.ProjectDao;

//@Controller 애노테이션으로 변경
@Controller("/project/list.do")
public class ProjectListController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectListController setMemberDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }

  @RequestMapping
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
