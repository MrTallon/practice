package hutool;

import cn.hutool.system.SystemUtil;

/**
 * 系统调用
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-09-04 11:20
 */
public class SystemMethod {
    public static void main(String[] args) {
        System.out.println("----------------------------");
        System.out.println("Java Virtual Machine Specification信息");
        System.out.println(SystemUtil.getJvmSpecInfo());
        System.out.println("----------------------------");

        System.out.println("Java Virtual Machine Implementation信息");
        System.out.println(SystemUtil.getJvmInfo());
        System.out.println("----------------------------");

        System.out.println("Java Specification信息");
        System.out.println(SystemUtil.getJavaSpecInfo());
        System.out.println("----------------------------");

        System.out.println("Java Implementation信息");
        System.out.println(SystemUtil.getJavaInfo());
        System.out.println("----------------------------");

        System.out.println("Java运行时信息");
        System.out.println(SystemUtil.getJavaRuntimeInfo());
        System.out.println("----------------------------");

        System.out.println("系统信息");
        System.out.println(SystemUtil.getOsInfo());

        System.out.println("用户信息");
        System.out.println(SystemUtil.getUserInfo());

        System.out.println("当前主机网络地址信息");
        System.out.println(SystemUtil.getHostInfo());

        System.out.println("运行时信息，包括内存总大小、已用大小、可用大小等");
        System.out.println(SystemUtil.getRuntimeInfo());
    }
}
