package cn.kidjoker.JavaExercise.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class ServerrSocket {

	private static ServerSocket serverSocket;
	
	private static Socket socket;
	
	private static BufferedReader bs;
	
	private static PrintWriter pw;
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Thread1());
		thread.start();
	}
	
	static class Thread1 implements Runnable {
		public void run() {
			try {
				char[] buf = new char[1024];
				
				serverSocket = new ServerSocket(8081);
				
				while(true) {
					socket = serverSocket.accept();
					
					bs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw = new PrintWriter(socket.getOutputStream());
					
					int data = bs.read(buf);
					while(data != -1) {
						System.out.println(buf);
						data = bs.read(buf);
					}
					data = 0;
				}
			} 
			catch (Exception e) {
			}
		}
	}
}
