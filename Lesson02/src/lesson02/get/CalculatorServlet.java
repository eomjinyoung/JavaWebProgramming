package lesson02.get;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Hashtable<String, Operator> operatorTable = 
			new Hashtable<String, Operator>();
	
	public CalculatorServlet() {
		// 연산자 처리기를 등록
		operatorTable.put("+", new PlusOperator());
		operatorTable.put("-", new MinusOperator());
		operatorTable.put("*", new MultipleOperator());
		operatorTable.put("/", new DivideOperator());
	}
	
	@Override
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// 클라이언트에서 보낸 값을 꺼낸다.
		String op = request.getParameter("op");
		double v1 = Double.parseDouble(request.getParameter("v1"));
		double v2 = Double.parseDouble(request.getParameter("v2"));
		
		// 클라이언트로 출력하기 위해 준비한다.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>계산 결과</h1>");
		out.println("결과: ");
		
		// 연산을 수행한 후 결과를 클라이언트로 출력한다.
		try {
			Operator operator = operatorTable.get(op);
			if (operator == null) {
				out.println("존재하지 않는 연산자 입니다.");
			} else {
				double result = operator.execute(v1, v2);
				out.println( String.format("%.3f", result) );
			}
		} catch (Exception e) {
			out.println("연산 오류가 발생하였습니다.");
		}
		
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
