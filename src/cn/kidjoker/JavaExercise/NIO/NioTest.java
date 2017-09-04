package cn.kidjoker.JavaExercise.NIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class NioTest {
	
	/* IO opertion */
	@Test public void test1() {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("d:\\spring-context.xml"));
			
			byte[] buf = new byte[256];
			int data = in.read(buf);
			while(data != -1) {
				for(int i = 0; i < data; i++) {
					System.out.print((char)buf[i]);
				}
				System.out.println();
				data = in.read(buf);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(in != null) {
					in.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* NIO operation */
	@Test public void test2() {
		RandomAccessFile raFile = null;
		try {
			raFile = new RandomAccessFile("d:\\spring-context.xml", "rw");
			FileChannel fcChannel = raFile.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			int data = fcChannel.read(buffer);
			System.out.println(data);
			
			while(data != -1) {
				buffer.flip();
				if(buffer.hasRemaining()) {
					System.out.println(buffer.get());
				}
				
				buffer.compact();
				data = fcChannel.read(buffer);	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(raFile != null) {
					raFile.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
