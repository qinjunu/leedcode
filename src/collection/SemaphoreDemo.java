package collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 绾跨▼姹�
        ExecutorService exec = Executors.newCachedThreadPool();
        // 鍙兘5涓嚎绋嬪悓鏃惰闂�
        final Semaphore semp = new Semaphore(5);
        // 妯℃嫙20涓鎴风璁块棶
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 鑾峰彇璁稿彲
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        // 璁块棶瀹屽悗锛岄噴鏀�
                        semp.release();
                    } catch (InterruptedException e) {
                    }
                }
            };
            exec.execute(run);
        }
        // 閫�鍑虹嚎绋嬫睜
        exec.shutdown();
    }
}
