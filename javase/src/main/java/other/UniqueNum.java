package other;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 生成唯一数字
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-09-14 18:00
 */
public class UniqueNum {

    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");
    private static final ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");

    public static void main(String[] args) {
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if (SEQ.intValue() > 9990) {
            SEQ.getAndSet(1000);
        }
        String a = dataTime.format(DF_FMT_PREFIX) + SEQ.getAndIncrement();
        System.out.println(a);


        // 多插入情况下，CopyOnWriteArrayList效率属实不大行
        List<Integer> orderNos = new CopyOnWriteArrayList<>();
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        long t1 = System.currentTimeMillis();
        IntStream.range(0, 1000).parallel().forEach(orderNos::add);
        long t2 = System.currentTimeMillis();
        IntStream.range(0, 1000).parallel().forEach(list::add);
        long t3 = System.currentTimeMillis();

        System.out.println("CopyOnWriteArrayList time : " + (t2 - t1));
        System.out.println("synchronizedList time : " + (t3 - t2));
    }

    /**
     * 随机获得Long类型数字
     * @return Long
     */
    public static Long num() {
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if (SEQ.intValue() > 9990) {
            SEQ.getAndSet(1000);
        }
        String a = dataTime.format(DF_FMT_PREFIX) + SEQ.getAndIncrement();
        return Long.valueOf(a);
    }
}