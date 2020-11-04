package concurrent;

import java.util.concurrent.Phaser;

/**
 * 相位器
 * phase
 * arrive
 * register
 * arriveAndDerRegister：到达并注销，对阶段有操作，如果总数减到0，阶段直接变为一个负数
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-30 01:20
 */
public class CountDownPlus {
    public static void main(String[] args) {
        test1();

    }

    /**
     * 模拟循环屏障
     */
    private static void test1() {
        Phaser phaser = new Phaser(5);
        getInfo(phaser);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Double(Math.random() * 3000).longValue());
                    System.out.println(Thread.currentThread().getName() + "玩家准备就绪");
                    // 到达不阻塞
                    phaser.arrive();
//                    System.out.println(Thread.currentThread().getName() + "选择英雄");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // 必须等待第0阶段完成再执行其他阶段
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("游戏开始");
    }

    /**
     * 模拟循环屏障
     */
    private static void test2() {
        Phaser phaser = new Phaser(5);
        getInfo(phaser);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Double(Math.random() * 3000).longValue());
                    System.out.println(Thread.currentThread().getName() + "玩家准备就绪");
                    // 到达并等待
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(Thread.currentThread().getName() + "选择英雄");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void getInfo(Phaser phaser) {
        System.out.println("阶段: " + phaser.getPhase());
        System.out.println("到达数: " + phaser.getArrivedParties());
        System.out.println("未到达数: " + phaser.getUnarrivedParties());
        System.out.println("总数: " + phaser.getRegisteredParties());
    }
}
