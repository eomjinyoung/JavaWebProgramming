package spms.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.vo.Member;

//2. 프런트 컨트롤러 적용  
@WebServlet("/auth/login")
public class LogInServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.setAttribute("viewUrl", "/auth/LogInForm.jsp");
  }

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      ServletContext sc = this.getServletContext();
      MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao"); 
      Member member = memberDao.exist(
          request.getParameter("email"), 
          request.getParameter("password"));
      if (member != null) {
        HttpSession session = request.getSession();
        session.setAttribute("member", member);
        request.setAttribute("viewUrl", "redirect:../member/list.do");
      } else {
        request.setAttribute("viewUrl", "/auth/LogInFail.jsp");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
