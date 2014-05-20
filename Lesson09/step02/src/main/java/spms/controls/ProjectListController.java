package spms.controls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.dao.ProjectDao;

//스프링 MVC의 페이지 컨트롤러로 변경
@Component("/project/list.do")
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
