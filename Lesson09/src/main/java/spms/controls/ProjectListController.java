package spms.controls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.bind.DataBinding;
import spms.dao.ProjectDao;

//스프링 애노테이션(@Component)으로 변경
@Component("/project/list.do")
public class ProjectListController implements Controller, DataBinding {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectListController setMemberDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "orderCond", String.class
    };
  } 

  @Override
  public String execute(Map<String, Object> model) throws Exception {
  	HashMap<String,Object> paramMap = new HashMap<String,Object>();
  	paramMap.put("orderCond", model.get("orderCond"));
  	
    model.put("projects", projectDao.selectList(paramMap));
    return "/project/ProjectList.jsp";
  }
}
