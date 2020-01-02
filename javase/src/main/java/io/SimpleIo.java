package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 简单读写
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-30 21:13
 * https://www.cnblogs.com/fysola/p/6143939.html
 */
public class SimpleIo {

    private static List<String> list = new ArrayList<>();

    private static void read() throws IOException {
        list = Files.readAllLines(Paths.get("/Users/yangbo/Desktop/before.txt"), StandardCharsets.UTF_8);
    }

    private static void write(List<String> l) throws IOException {
        Files.write(Paths.get("/Users/yangbo/Desktop/after.txt"), l, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static void distinct() throws IOException {
        read();
        // 去重
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        write(collect);
    }

    public static void main(String[] args) throws IOException {
        // 过滤 0-10 的奇数
        IntStream.range(0, 10).filter(i -> i % 2 == 0).forEach(System.out::println);
    }
}
