package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0.0
 * @description: lanbda遍历集合
 * @author: yangbo
 * @create: 2019-10-21 23:34
 */
public class ForEach {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Hello E");
            }
        });


        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        //输出：A,B,C,D,E
        strings.forEach(System.out::println);
        //输出 : C
        strings.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println(item);
            }
        });
    }
}
