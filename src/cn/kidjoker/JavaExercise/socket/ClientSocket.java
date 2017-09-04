package cn.kidjoker.JavaExercise.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
	
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
				socket = new Socket("127.0.0.1", 8081);
				
				bs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				pw.print("tea or coffee\n");
				
				pw.flush();
				System.out.println("hahaha");
				System.out.println(bs.readLine());
			} 
			catch (UnknownHostException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(socket != null) {
						socket.close();
					}
					if(pw != null) {
						pw.close();
					}
					if(bs != null) {
						bs.close();
					}
				}
				catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
