package com.eomjinyoung.lesson01.exam02.multiserver;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorWorker extends Thread {
	static int count;
	
	Socket socket;
	Scanner in;
	PrintStream out;
	
	public CalculatorWorker(Socket socket) throws Exception {
		count++;
		this.socket = socket;
		in = new Scanner(socket.getInputStream());
		out = new PrintStream(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		System.out.println("[thread-" + count + "] processing the client request.");
		
		String operator = in.nextLine();
		double a = Double.parseDouble(in.nextLine());
		double b = Double.parseDouble(in.nextLine());
		double r = 0;
		
		try {
			switch (operator) {
			case "+": r = a + b; break;
			case "-": r = a - b; break;
			case "*": r = a * b; break;
			case "/": 
				if (b == 0) throw new Exception("0 으로 나눌 수 없습니다!");
				r = a / b; break;
			default:
				throw new Exception("해당 연산을 지원하지 않습니다!");
			}
			out.println("success");
			out.println(r);
			
		} catch (Exception err) {
			out.println("failure");
			out.println(err.getMessage());
		}
		
		try { out.close(); } catch (Exception e) {}
		try { in.close(); } catch (Exception e) {}
		try { socket.close(); } catch (Exception e) {}
		
		System.out.println("[thread-" + count + "] closed client.");
	}
}
