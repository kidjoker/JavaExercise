package cn.kidjoker.JavaExercise.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

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
				serverSocket = new ServerSocket(8081);
				
				while(true) {
					socket = serverSocket.accept();
					
					bs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw = new PrintWriter(socket.getOutputStream());
					
					Thread thread = Thread.currentThread();
					thread.sleep(6000);
					
					System.out.println(bs.readLine());
					pw.write("橙汁");
				}
			} 
			catch (UnknownHostException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(serverSocket != null) {
						serverSocket.close();
					}
					if(socket != null) {
						socket.close();
					}
					if(bs != null) {
						bs.close();
					}
					if(pw != null) {
						pw.close();
					}
				}
				catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
