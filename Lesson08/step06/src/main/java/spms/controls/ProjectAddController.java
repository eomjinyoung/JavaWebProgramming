package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spms.dao.ProjectDao;
import spms.vo.Project;

//@Controller 애노테이션으로 변경
@Controller("/project/add.do")
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
