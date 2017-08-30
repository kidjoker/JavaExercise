package cn.kidjoker.JavaExercise.IO.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.junit.Test;

public class PipeTest {
	
	@SuppressWarnings("resource")
	@Test public void test() throws IOException {
		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);
		
		Thread thread1 = new Thread( new Runnable() {
			@Override
			public void run() {
				try {
					output.write("hello world,pipe!".getBytes());
				}
				catch (IOException e) {
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = input.read();
					while(data != -1) {
						System.out.println(data);
						data = input.read();
					}
				}
				catch (IOException e) {
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}
