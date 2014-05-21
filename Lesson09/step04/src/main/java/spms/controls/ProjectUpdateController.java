package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spms.dao.ProjectDao;
import spms.vo.Project;

//@Controller 애노테이션으로 변경
@Controller("/project/update.do")
public class ProjectUpdateController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    Project project = (Project)model.get("project");
    
    if (project.getTitle() == null) { 
      Integer no = (Integer)model.get("no");
      Project detailInfo = projectDao.selectOne(no);
      model.put("project", detailInfo);
      return "/project/ProjectUpdateForm.jsp";

    } else { 
      projectDao.update(project);
      return "redirect:list.do";
    }
  }
}
