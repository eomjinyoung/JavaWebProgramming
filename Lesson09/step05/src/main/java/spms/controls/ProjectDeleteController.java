package spms.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spms.dao.ProjectDao;

//@RequestParam 적용
@Controller
public class ProjectDeleteController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectDeleteController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  @RequestMapping("/project/delete.do")
  public String execute(int no) throws Exception {
    projectDao.delete(no);
    return "redirect:list.do";
  }
}
