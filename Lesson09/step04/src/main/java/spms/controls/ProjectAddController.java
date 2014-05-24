package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.controls.ProjectAddController;
import spms.dao.ProjectDao;
import spms.vo.Project;

//@RequestMapping 적용
@Controller
public class ProjectAddController {
	ProjectDao projectDao;
	
	@Autowired
	public ProjectAddController setProjectDao(ProjectDao projectDao) {
	  this.projectDao = projectDao;
	  return this;
	}
	
	@RequestMapping("/project/add.do")
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
