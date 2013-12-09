package spms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.vo.Member;

//1. 시작 소스   
//@WebServlet("/auth/login")
public class LogInServlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher(
        "/auth/LogInForm.jsp");
    rd.forward(request, response);
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
        response.sendRedirect("../member/list");

      } else {
        RequestDispatcher rd = request.getRequestDispatcher(
            "/auth/LogInFail.jsp");
        rd.forward(request, response);
      }
    } catch (Exception e) {
      throw new ServletException(e);

    }
  }
}
