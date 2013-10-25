package lesson01.exam02.multiserver;

import java.net.ServerSocket;
import java.net.Socket;

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
				socket = serverSocket.accept();
				System.out.println("connected to client.");
				
				new CalculatorWorker(socket).start();
				
			} catch (Throwable e) {
				System.out.println("connection error!");
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		CalculatorServer app = new CalculatorServer(8888);
		app.service();
	}
}

