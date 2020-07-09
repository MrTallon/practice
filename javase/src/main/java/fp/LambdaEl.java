package fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lambda表达式
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-03 10:10
 */
public class LambdaEl {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 通过lambda表达式筛选字符串
     */
    private static void test1() {
        List<String> list = new ArrayList<>(
                Arrays.asList("1", "abc", "Bilibili", "Nacos", "JavaScript", "oAuth", "yangbo", "JavaScript", " "));
        // 长度>=5的字符串，并且忽略大小写、去除重复字符串，然后按字母排序，最后用“❤️”连接成一个字符串输出
        String result = list.stream()
                // 筛选
                .filter(i -> !isNum(i))
                .filter(i -> i.length() >= 5)
                // 转小写
                .map(String::toLowerCase)
                // 去重
                .distinct()
                // 排序
                .sorted(Comparator.naturalOrder())
                // 拼接
                .collect(Collectors.joining("❤️"));
        System.out.println(result);
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str 参数字符串
     * @return 是否为数字
     */
    private static Boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
