package variable;

import java.lang.reflect.Field;

/**
 * @author yangbo
 */
public class CashVariable {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        swap(a, b);
        System.out.println(" a : " + a);
        System.out.println(" b : " + b);
    }

    private static void swap(Integer a, Integer b) {
        try {
            Integer temp = new Integer(a);
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a, b);
            // value.set 会将Integer缓存值改变，new Integer 不需要调用缓存
            value.set(b, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
