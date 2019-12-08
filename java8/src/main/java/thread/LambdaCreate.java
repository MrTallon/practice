package thread;

/**
 * @version v1.0.0
 * @description: lambda 创建线程
 * @author: yangbo
 * @create: 2019-10-16 13:52
 */
public class LambdaCreate {
    public static void main(String[] args) {

        int a = 100_000_000;

        new Thread(() -> System.out.println("Before Java8 ")).start();

    }

    private static void syso() {
        System.out.println(1+ "11");
    }
}
