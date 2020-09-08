package hutool;

import cn.hutool.bloomfilter.BitMapBloomFilter;

import java.util.Date;

/**
 * 布隆
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-09-04 14:15
 */
public class BloomMethod {
    public static void main(String[] args) {
        BitMapBloomFilter filter = new BitMapBloomFilter(10);
        filter.add("123");
        filter.add("abc");
        filter.add("ddd");

        // 查找
        System.out.println(filter.contains("1231"));

        Date date = new Date();
        System.out.println(date.getTime());
    }
}
