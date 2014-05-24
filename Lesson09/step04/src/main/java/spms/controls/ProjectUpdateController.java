package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.dao.ProjectDao;
import spms.vo.Project;

//@RequestMapping 적용
@Controller
public class ProjectUpdateController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  @RequestMapping("/project/update.do")
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
