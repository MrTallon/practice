package jvm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-07 00:17
 */
public class TestJVM {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
//        fillHeap(1000);

        LocalDateTime l = LocalDateTime.now();
        LocalDateTime l1 = l.minusDays(2);
        if (l1.plusDays(2).getDayOfYear() == l.getDayOfYear()) {
            System.out.println("可学下一碎片");
        }

        System.out.println(l);

    }
}
