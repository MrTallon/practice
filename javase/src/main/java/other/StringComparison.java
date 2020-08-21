package other;

/**
 * 字符串比较案例
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-12 00:11
 */
public class StringComparison {

    public static void main(String[] args) {
        String foo = "ABC";

        // 前面和后面每个字符完全一样，返回 0
        String bar01 = "ABC";
        System.out.println(foo.compareTo(bar01));

        // 前面每个字符完全一样，返回：后面就是字符串长度差
        String bar02 = "ABCD";
        String bar03 = "ABCDE";
        // -1 (前面相等,foo 长度小 1)
        System.out.println(foo.compareTo(bar02));
        // -2 (前面相等,foo 长度小 2)
        System.out.println(foo.compareTo(bar03));

        // 前面每个字符不完全一样，返回：出现不一样的字符 ASCII 差
        String bar04 = "ABD";
        String bar05 = "aABCD";
        // -1  (foo 的 'C' 字符 ASCII 码值为 67，bar04 的 'D' 字符 ASCII 码值为 68。返回 67 - 68 = -1)
        System.out.println(foo.compareTo(bar04));
        // -32 (foo 的 'A' 字符 ASCII 码值为 65，bar04 的 'a' 字符 ASCII 码值为 97。返回 65 - 97 = -32)
        System.out.println(foo.compareTo(bar05));

        String bysocket01 = "泥瓦匠";
        String bysocket02 = "瓦匠";
        // -2049 （泥 和 瓦的 Unicode 差值）
        System.out.println(bysocket01.compareTo(bysocket02));
    }
}

