package jvm;

/**
 * 测试死锁
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-12-28 01:17
 */
public class TestDie {
    public static void main(String[] args) {
        final int[] a = {100};
        new Thread(() ->{
            while (a[0] > 0) {
                System.out.println(a[0]--);;
            }}, "A").start();
        new Thread(() ->{
            while (a[0] > 0) {
                System.out.println(a[0]--);;
            }}, "B").start();
        new Thread(() ->{
            while (a[0] > 0) {
                System.out.println(a[0]--);;
            }}, "C").start();
    }
}
