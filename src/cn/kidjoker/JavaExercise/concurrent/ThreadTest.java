package cn.kidjoker.JavaExercise.concurrent;

public class ThreadTest {
	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
					counter.add(2);
					System.out.println(counter.count);
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				counter.add(3);
				System.out.println(counter.count);
			}
		});
		
		threadA.start();
		threadB.start();
	}
}

class Counter {
	protected long count = 0;
	
	public void add(long value) {
		this.count = this.count + value;
	}
}
