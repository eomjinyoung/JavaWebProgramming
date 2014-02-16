package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.controls.Controller;
import spms.dao.ProjectDao;
import spms.vo.Project;

@Component("/project/update.do")
public class ProjectUpdateController implements Controller, DataBinding {
  ProjectDao projectDao;
  
  public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class,
        "project", spms.vo.Project.class
    };
  }
  
  @Override
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
