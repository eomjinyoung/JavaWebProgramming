package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.bind.DataBinding;
import spms.dao.ProjectDao;
import spms.vo.Project;

//스프링 애노테이션(@Component)으로 변경
@Component("/project/update.do")
public class ProjectUpdateController implements Controller, DataBinding {
  ProjectDao projectDao;
  
  @Autowired
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
