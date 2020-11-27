package jvm;

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
        List<String> s = null;
        for (String s1 : s) {
            System.out.println(s1);
        }
        // 这是test分支新增内容，欲同步到master

//        fillHeap(1000);
    }
}
