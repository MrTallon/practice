package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 计数器
 * 主要方法：countDown\await
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-30 00:42
 */
public class CountDown {
    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }

    /**
     * 一开始为线程设置一个初始值，每创建一个线程就countDown(-1)，一直减到0就执行await
     * 计数器不可以循环使用，countDown不会阻塞，await会阻塞
     */
    private static void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Double((Math.random()*3000)).longValue());
                    System.out.println(Thread.currentThread().getName() + "玩家准备就绪");
                    // -1
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + "选英雄");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        // 当5减为0的时候则执行
        countDownLatch.await();
        System.out.println("游戏开始");
    }

    /**
     * 循环屏障
     * 特点就是可循环，如果存在10个玩家，可以每5个为一组
     */
    private static void test2() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Double(Math.random() * 3000).longValue());
                    System.out.println(Thread.currentThread().getName() + "玩家准备就绪");
                    // 相当于计数器中的 countDown+await
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "选择英雄");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
