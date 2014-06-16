package spms.controls;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spms.dao.ProjectDao;
import spms.vo.Project;

//@RequestParam 적용
@Controller
public class ProjectAddController {
	final static Logger log = Logger.getLogger(ProjectAddController.class);
	
  ProjectDao projectDao;
  
  @Autowired
  public ProjectAddController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  @RequestMapping(value="/project/add.do", method=RequestMethod.GET)
  public String addForm() {
  	return "/project/ProjectForm.jsp";
  }
  
  @RequestMapping(value="/project/add.do", method=RequestMethod.POST)
  public String add(Project project) throws Exception {
    projectDao.insert(project);
    return "redirect:list.do";
  }
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
  	log.debug("=> initBinder()");
  	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  	dateFormat.setLenient(false);
  	binder.registerCustomEditor(
  			java.util.Date.class, new CustomDateEditor(dateFormat, true));
  }
}
