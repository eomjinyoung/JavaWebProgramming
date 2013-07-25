package com.eomjinyoung.lesson01.exam02.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorAgent {
	String ip;
	int port;
	
	public CalculatorAgent(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public double compute(String operator, double a, double b) throws Exception {
		Socket socket = null;
		PrintStream out = null;
		Scanner in = null;
		
		try {
			socket = new Socket(ip, port);
			out = new PrintStream(socket.getOutputStream());
			in = new Scanner(socket.getInputStream());
			
			out.println(operator);
			out.println(a);
			out.println(b);
			out.flush();
			
			String state = in.nextLine();
			if (state.equals("success")) {
				return Double.parseDouble(in.nextLine());
			} else {
				throw new Exception(in.nextLine());
			}
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {out.close();} catch(Exception e) {}
			try {in.close();} catch(Exception e) {}
			try {socket.close();} catch(Exception e) {}
		}
	}
}
