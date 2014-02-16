package spms.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.bind.DataBinding;
import spms.bind.ServletRequestDataBinder;
import spms.context.ApplicationContext;
import spms.controls.Controller;
import spms.listeners.ContextLoaderListener;

// 페이지 컨트롤러를 찾을 때 ApplicationContext의 사용
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
      ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
      
      // 페이지 컨트롤러에게 전달할 Map 객체를 준비한다. 
      HashMap<String,Object> model = new HashMap<String,Object>();
      model.put("session", request.getSession());
      
      Controller pageController = (Controller) ctx.getBean(servletPath);
      if (pageController == null) {
        throw new Exception("요청한 서비스를 찾을 수 없습니다.");
      }
      
      if (pageController instanceof DataBinding) {
        prepareRequestData(request, model, (DataBinding)pageController);
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

  private void prepareRequestData(HttpServletRequest request,
      HashMap<String, Object> model, DataBinding dataBinding)
      throws Exception {
    Object[] dataBinders = dataBinding.getDataBinders();
    String dataName = null;
    Class<?> dataType = null;
    Object dataObj = null;
    for (int i = 0; i < dataBinders.length; i+=2) {
      dataName = (String)dataBinders[i];
      dataType = (Class<?>) dataBinders[i+1];
      dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
      model.put(dataName, dataObj);
    }
  }
}
