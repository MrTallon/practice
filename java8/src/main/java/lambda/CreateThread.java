package lambda;

/**
 * 创建线程的几种方式
 *
 * @author YangBo
 * @date 2019/06/29
 */
public class CreateThread {

    public static void main(String[] args) {
        Runnable runner = () -> {
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < 100; i++) {
                System.out.println(s.append("h"));
            }
        };
        //注意：同一个线程不可以启动多次
        new Thread(runner).start();



        System.out.println("任务完成");
    }
}
