package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spms.dao.ProjectDao;

//@Controller 애노테이션으로 변경
@Controller("/project/delete.do")
public class ProjectDeleteController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectDeleteController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    Integer no = (Integer)model.get("no");
    projectDao.delete(no);
    
    return "redirect:list.do";
  }
}
