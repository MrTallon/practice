package time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计算员工工作时长
 *
 * @author YangBo
 * @date 2018/10/27
 * <p>
 * desc
 * 不满30分钟不计入时长
 * 大于30分钟不满一个小时按0.5小时计算
 * 忽略天数差
 * 上班时间大于下班时间，返回-1
 */
public class CalcHour {
    public static void main(String[] args) throws Exception {

        //格式化Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        Date begin = sdf.parse("2018-10-18 8:20");
        Date end = sdf.parse("2018-10-10 18:30");

        System.out.println("您今天的工作时间为 ：" + calcWorkTime(begin, end));
    }

    private static double calcWorkTime(Date begin, Date end) {

        //计算天/时/分的毫秒
        long nd = 24 * 60 * 60 * 1000;
        long nh = 60 * 60 * 1000;
        long nm = 60 * 1000;

        //两个时间毫秒差
        long diff = end.getTime() - begin.getTime();

        if (diff < 0) {
            return -1;
        }

        //计算时分
        long hour = diff % nd / nh;
        long min = diff % nd % nh / nm;

        //是否超过半小时
        long sh = min * 10 / 60;

        if (sh < 5) {
            return hour;
        }
        return hour + 0.5;
    }
}
