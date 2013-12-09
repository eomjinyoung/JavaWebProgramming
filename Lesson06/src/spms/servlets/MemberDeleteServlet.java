package spms.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;

//2. 프런트 컨트롤러 적용 
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
         
      memberDao.delete(Integer.parseInt(request.getParameter("no")));
      request.setAttribute("viewUrl", "redirect:list.do");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
