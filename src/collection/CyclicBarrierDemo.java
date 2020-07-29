package collection;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        new CyclicBarrierDemo().go();
    }
    private void go() throws InterruptedException {
        // 鍒濆鍖栨爡鏍忕殑鍙備笌鑰呮暟涓�3
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        // 渚濇鍒涘缓3涓嚎绋�,骞跺惎鍔�
        new Thread(new Task(cyclicBarrier), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier), "Thread3").start();
    }
    class Task implements Runnable {
        private CyclicBarrier cyclicBarrier;
        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("绾跨▼" + Thread.currentThread().getName() + "宸茬粡鍒拌揪" + System.currentTimeMillis());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("绾跨▼" + Thread.currentThread().getName() + "寮�濮嬪鐞�" + System.currentTimeMillis());
        }
    }
}
