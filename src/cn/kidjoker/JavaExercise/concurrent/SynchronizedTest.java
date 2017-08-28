package cn.kidjoker.JavaExercise.concurrent;

import org.junit.Test;

public class SynchronizedTest implements Runnable {
	
	@Override
	public void run() {
		synchronized(this) {
			MyJob.CreateJob().doSomething();
		}
	}
	
	private static class MyJob{
		private void doSomething() {
			synchronized (this) {
				for(int i = 5; i > 0; i--) {
					System.out.println(i + " " + Thread.currentThread().getName());
				}
			}
		}
		
		private void doAnotherThing() {
			for(int i = 5; i > 0; i--) {
				System.out.println(i + " " + Thread.currentThread().getName());
			}
		}
		
		public static MyJob CreateJob() {
			return new MyJob();
		}
	}
	
	@Test public void test() throws InterruptedException {
		SynchronizedTest thread = new SynchronizedTest();
		Thread thread1 = new Thread(thread,"A");
		Thread thread2 = new Thread(thread,"B");
		
		thread1.start();
		thread2.start();
	}
	
}
