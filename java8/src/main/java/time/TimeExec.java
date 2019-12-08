package time;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 格式化时间 练习
 *
 * @author Tallon
 * @date 2018/09/04
 */
public class TimeExec {
    public static void main(String[] args) throws Exception {
        File file = new File("images/chaoyue.jpg");
        // 最后一次修改时间(时间戳)
        Long time = file.lastModified();
        System.out.println("照片的最后一次修改时间是 ： " + time);

        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ok = sdf.format(time);
        System.out.println(ok);

        Date a = new Date();
        System.out.println(a);
        System.out.println(sdf.format(a));

        String birthday = "1986-03-09 00:00:00";
        Date date = sdf.parse(birthday);
        long x = date.getTime();
        x = time - x;
        System.out.println(x);
        System.out.println("-----------");
        System.out.println(sdf.format(x));

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(x);
        System.out.println(x);
        System.out.println(cal.get(1));
        System.out.println(cal.get(2) + 1);
    }

}
