package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 计算老大住酒店花销
 *
 * @author YangBo
 * @date 2018/10/27
 * <p>
 * desc:
 * 老大从1979年12月12号开始住在喜来登，
 * 酒店平日（周一至周五）330每晚，周末（周六/日）550每晚
 * 计算老大住到现在需话费多少钱
 */
public class CalcDay {

    public static void main(String[] args) throws Exception {
        String date = "2018-11-1";
        System.out.println(calc(date));

    }

    public static int calc(String date) throws Exception {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前时间
        long now = System.currentTimeMillis();
        //获取起始时间
        long begin = sdf.parse(date).getTime();
        //平日
        int a = 0;
        //周末
        int b = 0;
        for (long x = begin; x < now - 24 * 3600000; x = x + 24 * 3600000) {
            //从给定的long值设置日历的当前时间
            calendar.setTimeInMillis(x);
            int day = calendar.get(7);
            if (day == 1 || day == 7) {
                b++;
            } else {
                a++;
            }
        }
        return a * 330 + b * 550;
    }

}
