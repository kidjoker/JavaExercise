package cn.kidjoker.JavaExercise.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {
	public static void main(String[] args) throws InterruptedException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		SocketChannel sc = null;
		
		try {
			sc = SocketChannel.open();
			sc.configureBlocking(false);
			sc.connect(new InetSocketAddress("127.0.0.1", 8081));
			
			if(sc.finishConnect()) {
				int i = 0;
				buffer.clear();
				
				buffer.put("hello,world".getBytes());
				buffer.flip();
				
				sc.write(buffer);
				
				Thread thread = Thread.currentThread();
				thread.sleep(1000);
				
				System.out.println("haha");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(sc != null) {
					sc.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
