package time;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * JDK8 中的时间相关方法总结
 * 参考文档：https://blog.csdn.net/forwujinwei/article/details/78060618
 *
 * @author YangBo
 * @date 2019/03/07
 */
public class JdkDate {

    public static void main(String[] args) throws Exception {
        //获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期是 ： " + today);
        System.out.println(today.getYear() + "年" + today.getMonthValue() + "月" + today.getDayOfMonth() + "日");

        //格式化指定日期(月份从1开始)
        LocalDate dateOfBirth = LocalDate.of(1995, 05, 12);
        System.out.println("您输入的日期是：" + dateOfBirth);

        //检查两个日期是否相等
        System.out.println("检查两个时间是否相等" + today.equals(dateOfBirth));

        //检查重复事件（比如生日，信用卡还款日。判断月，日即可）
        MonthDay birth = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);

        if (currentMonthDay.equals(birth)) {
            System.out.println("今天生日");
        } else {
            System.out.println("没到生日");
        }
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间：" + localTime);

        LocalTime two = localTime.plusHours(2).plusMinutes(20);
        System.out.println("当前时间的2小时20分钟后：" + two);

        //可以增加/减少一个月，一年，一小时，一分等等，
        LocalDate oneWeek = today.plus(1, ChronoUnit.WEEKS);
        System.err.println(ChronoUnit.WEEKS+"    "+ChronoUnit.YEARS);
        LocalDate lastWeek = today.minus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期是：" + oneWeek);
        System.out.println("一周前的日期是：" + lastWeek);

        Clock clock = Clock.systemUTC();
        System.out.println("根据系统时钟和UTC得到当前时间：" + clock);


        //判断某个日期在另一个日期的前面还是后面(时间类似)
        System.out.println("日期：" + today + "是否在日期：" + dateOfBirth + "之后：" + today.isAfter(dateOfBirth));
        System.out.println("日期：" + today + "是否在日期：" + dateOfBirth + "之前：" + today.isBefore(dateOfBirth));

        //将本地时间转换为另一个时区对应的时间
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.of(ZoneId.SHORT_IDS.get("ACT"));
        ZonedDateTime dateTime = ZonedDateTime.of(localDateTime, zone);
        System.out.println("现在时区的时间在特定时区的时间：" + dateTime);

        //某月有几天
        YearMonth yearMonth = YearMonth.now();
        System.out.printf("%s 月有 %d 天%n", yearMonth, yearMonth.lengthOfMonth());

        //闰年
        System.out.printf("%s 是否是闰年：%s \r\n", today, today.isLeapYear());

        //两个日期之间相差几年几天几月
        Period period = Period.between(dateOfBirth, today);
        System.out.printf("日期 %s 和日期 %s 相差 %s 年 %s 月 %s 天 \r\n", dateOfBirth, today, period.getYears(), period.getMonths(), period.getDays());

        //时间戳
        Instant timeStamp = Instant.now();
        System.out.println("当前的时间戳：" + timeStamp);

        //使用自定义的格式器来对日期进行解析/格式化
        //SimpleDateFormat并不是线程安全的
//        String tommer = "20160414";
//        LocalDate format = LocalDate.parse(tommer, DateTimeFormatter.BASIC_ISO_DATE);
//        System.out.printf("字符 %s 格式化后的日期是 %s \r\n", tommer, format);

        String goodDay = "03 07 2018";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
//        LocalDate fridy = LocalDate.parse(goodDay, formatter);
//        System.out.printf("字符 %s 转化成功后的日期是 %s \r\n", goodDay, fridy);

        //对日期进行格式化，转换成字符串
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MM dd yyyy HH:mm:ss");
//        String landing = localTime.format(timeFormatter);
//        System.out.printf("%s 转化成功后的字符是 %s \r\n", localTime, landing);


    }

}
