package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.dao.ProjectDao;
import spms.vo.Project;

//스프링 애노테이션(@Component)으로 변경
@Component("/project/add.do")
public class ProjectAddController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectAddController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    Project project = (Project)model.get("project");
    if (project.getTitle() == null) {
      return "/project/ProjectForm.jsp";
      
    } else {
      projectDao.insert(project);
      return "redirect:list.do";
    }
  }
}
