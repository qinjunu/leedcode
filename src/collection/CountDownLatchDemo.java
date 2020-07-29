package collection;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }
    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // 渚濇鍒涘缓3涓嚎绋�,骞跺惎鍔�
        new Thread(new Task(countDownLatch), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread3").start();
        countDownLatch.await();
        System.out.println("鎵�鏈夌嚎绋嬪凡鍒拌揪,涓荤嚎绋嬪紑濮嬫墽琛�" + System.currentTimeMillis());
    }
    class Task implements Runnable {
        private CountDownLatch countDownLatch;
        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            System.out.println("绾跨▼" + Thread.currentThread().getName() + "宸茬粡鍒拌揪" + System.currentTimeMillis());
            countDownLatch.countDown();
        }
    }
}