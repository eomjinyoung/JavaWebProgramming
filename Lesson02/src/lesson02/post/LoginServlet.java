package lesson02.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트 값을 꺼내기 전에 문자셋 설정
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		// 클라이언트로 출력하기 위해 준비한다.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>로그인 결과</h1>");
		out.println(id + "님을 환영합니다.");
		out.println("</body></html>");
	}
}
