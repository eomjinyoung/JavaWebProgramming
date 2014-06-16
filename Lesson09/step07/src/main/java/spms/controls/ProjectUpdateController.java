package spms.controls;

import java.text.SimpleDateFormat;
import java.util.Map;

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
public class ProjectUpdateController {
  ProjectDao projectDao;
  
  @Autowired
  public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
    return this;
  }
  
  @RequestMapping(value="/project/update.do", method=RequestMethod.GET)
  public String updateForm(
  		int no,
  		Map<String, Object> model) throws Exception {
    Project detailInfo = projectDao.selectOne(no);
    model.put("project", detailInfo);
    return "/project/ProjectUpdateForm.jsp";
  }
  
  @RequestMapping(value="/project/update.do", method=RequestMethod.POST)
  public String update(Project project) throws Exception {
    projectDao.update(project);
    return "redirect:list.do";
  }
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
  	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  	dateFormat.setLenient(false);
  	binder.registerCustomEditor(
  			java.util.Date.class, new CustomDateEditor(dateFormat, true));
  }
}
