package time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

/**
 * @version v1.0.0
 * @description: LocalDate 测试类
 * @author: yangbo
 * @create: 2019-10-16 14:52
 */
public class LocalDates {
    public static void main(String[] args) {
        //LocalDate.now == new Date()
        LocalDate localDate = LocalDate.now();
        //LocalDate.now 实际调用了这个方法
        localDate = LocalDate.now(Clock.systemDefaultZone());
        //指定时间
        localDate = LocalDate.of(2019, 07, 15);
        //判断是不是闰年
        boolean isLeapYear = localDate.isLeapYear();
        System.out.printf("%d是不是闰年？，%s\n", localDate.getYear(), isLeapYear ? "是" : "否");
        //两天后
        LocalDate twoDaysLate = localDate.plusDays(2);
        System.out.println("两天后:" + twoDaysLate);
        //两周后
        LocalDate twoWeeksLate = localDate.plusMonths(2);
        System.out.println("两周后:" + twoDaysLate);
        //两月后
        LocalDate twoMonthsLate = localDate.plusMonths(2);
        System.out.println("两月后:" + twoMonthsLate);
        //两年后
        LocalDate twoYearsLate = localDate.plusYears(2);
        System.out.println("两年后:" + twoYearsLate);
        //两天前
        LocalDate twoDaysBefore = localDate.minusDays(2);
        System.out.println("两天前:" + twoDaysBefore);
        //两周前
        LocalDate twoWeeksBefore = localDate.minusWeeks(2);
        System.out.println("两周前:" + twoWeeksLate);
        //两月前
        LocalDate twoMonthsBefore = localDate.minusMonths(2);
        System.out.println("两月前" + twoMonthsBefore);
        //两年前
        LocalDate twoYearsBefore = localDate.minusYears(2);
        System.out.println("两年前" + twoYearsBefore);
        LocalDate anyTime = LocalDate.now().withMonth(10).withDayOfMonth(1);
        System.out.println("指定日期：" + anyTime);
        //今年的第一天
        LocalDate firstDayOfYear = localDate.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("今年的第一天：" + firstDayOfYear);
        //本月的最后一天, 类似的API还有很多
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的最后一天:" + lastDayOfMonth);
        //获取两个LocalDate的时间间隔
        Period period = localDate.until(lastDayOfMonth);
        System.out.println("离本月最后一天还有多少天？" + period.getDays());

        //通过Period 设置时间，增减时间, localdate 其实也是加减的Period
        LocalDate minus = localDate.minus(Period.parse("P1Y2M3D"));
        System.out.println(minus);
        //判断当前时间是否在某个时间之前
        boolean isBefore = localDate.isBefore(minus);
        System.out.println(localDate + "是否在" + minus + "之前");

        //获取一天最开始的时间
        LocalDateTime localDateTime = localDate.atStartOfDay();
        System.out.println("一天的初始时间" + localDateTime);

        //指定某天的具体时间
        LocalDateTime atTime = localDate.atTime(5, 6, 7);
        System.out.println("指定一天的某个时间" + atTime);

    }
}
