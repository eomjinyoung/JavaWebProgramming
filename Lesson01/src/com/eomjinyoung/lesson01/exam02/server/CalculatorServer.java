package com.eomjinyoung.lesson01.exam02.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
	private int port;
	
	public CalculatorServer(int port) {
		this.port = port;
	}
	
	public void service() throws Exception {
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("CalculatorServer startup:");
		
		Socket socket = null;
		
		while(true) {
			try {
				System.out.println("waiting client...");
				
				socket = serverSocket.accept();
				System.out.println("connected to client.");
				
				processRequest(socket);
				System.out.println("closed client.");
				
			} catch (Throwable e) {
				System.out.println("connection error!");
			}
		}
		
	}
	
	private void processRequest(Socket socket) throws Exception {
		Scanner in = new Scanner(socket.getInputStream());
		PrintStream out = new PrintStream(socket.getOutputStream());
	
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
		
		
		out.close();
		in.close();
		socket.close();
	}
	
	public static void main(String[] args) throws Exception {
		CalculatorServer app = new CalculatorServer(8888);
		app.service();
	}
}

