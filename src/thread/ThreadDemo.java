package thread;

public class ThreadDemo {
	public static void main(String[] args) {	
		MyThread mt1 = new MyThread("thread1");
		MyThread mt2 = new MyThread("thread2");
		MyThread mt3 = new MyThread("thread3");
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
