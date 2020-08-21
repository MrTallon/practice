package other;

import java.awt.*;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * 本机参数
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class LocalParam {
    public static void main(String[] args) throws Exception {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("本机名称是 ： " + address.getHostName());
        System.out.println("本机IP是 ： " + Arrays.toString(address.getAddress()));

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();
        System.out.println("本机像素宽高比 " + width + " ： " + height);

        //获取屏幕dpi
        int dpi = Toolkit.getDefaultToolkit().getScreenResolution();
        System.out.println("本机DPI ： " + dpi);

        //根据dpi和像素，计算物理尺寸
        System.out.println("宽 ： 高 = " + width / dpi + " : " + height / dpi);
    }

}
