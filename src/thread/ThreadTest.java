package thread;

public class ThreadTest {
	public static void attack() {
		System.out.println("Fight");
		System.out.println("Current thread is: "+Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				attack();
			}
		};
		System.out.println("Current main thread is: "+Thread.currentThread().getName());
		t.run();
//		t.start();
	}
}
