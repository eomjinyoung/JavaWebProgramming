package spms.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.controls.Controller;
import spms.controls.LogInController;
import spms.controls.LogOutController;
import spms.controls.MemberAddController;
import spms.controls.MemberDeleteController;
import spms.controls.MemberListController;
import spms.controls.MemberUpdateController;
import spms.vo.Member;

// Controller 규칙에 따라 페이지 컨트롤러를 호출
@SuppressWarnings("serial")
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    String servletPath = request.getServletPath();
    try {
      ServletContext sc = this.getServletContext();
      
      // 페이지 컨트롤러에게 전달할 Map 객체를 준비한다. 
      HashMap<String,Object> model = new HashMap<String,Object>();
      model.put("memberDao", sc.getAttribute("memberDao"));
      model.put("session", request.getSession());
      
      Controller pageController = null;
      
      if ("/member/list.do".equals(servletPath)) {
        pageController = new MemberListController();
      } else if ("/member/add.do".equals(servletPath)) {
        pageController = new MemberAddController();
        if (request.getParameter("email") != null) {
          model.put("member", new Member()
            .setEmail(request.getParameter("email"))
            .setPassword(request.getParameter("password"))
            .setName(request.getParameter("name")));
        }
      } else if ("/member/update.do".equals(servletPath)) {
        pageController = new MemberUpdateController();
        if (request.getParameter("email") != null) {
          model.put("member", new Member()
            .setNo(Integer.parseInt(request.getParameter("no")))
            .setEmail(request.getParameter("email"))
            .setName(request.getParameter("name")));
        } else {
          model.put("no", new Integer(request.getParameter("no")));
        }
      } else if ("/member/delete.do".equals(servletPath)) {
        pageController = new MemberDeleteController();
        model.put("no", new Integer(request.getParameter("no")));
      } else if ("/auth/login.do".equals(servletPath)) {
        pageController = new LogInController();
        if (request.getParameter("email") != null) {
          model.put("loginInfo", new Member()
            .setEmail(request.getParameter("email"))
            .setPassword(request.getParameter("password")));
        }
      } else if ("/auth/logout.do".equals(servletPath)) {
        pageController = new LogOutController();
      }
      
      // 페이지 컨트롤러를 실행한다.
      String viewUrl = pageController.execute(model);
      
      // Map 객체에 저장된 값을 ServletRequest에 복사한다.
      for (String key : model.keySet()) {
        request.setAttribute(key, model.get(key));
      }
      
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
        return;
      } else {
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }
}
