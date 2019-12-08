package thread;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.LongStream.*;
import java.io.*;
import java.nio.file.*;

/**
 * @version v1.0.0
 * @description: Parallel 方式寻找质数
 * @author: yangbo
 * @create: 2019-10-16 14:40
 */
public class ParallelPrime {
    static final int COUNT = 100_000;
    public static boolean isPrime(long n){
        return rangeClosed(2, (long)Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }
    public static void main(String[] args)
            throws IOException {
        List<String> primes =
                iterate(2, i -> i + 1)
                        .parallel()              // [1]
                        .filter(ParallelPrime::isPrime)
                        .limit(COUNT)
                        .mapToObj(Long::toString)
                        .collect(Collectors.toList());
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
    }
}
