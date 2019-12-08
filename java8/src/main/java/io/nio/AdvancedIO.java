package io.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 读写流进阶练习
 *
 * @author YangBo
 * @date 2019/09/03
 */
public class AdvancedIO {

    private static final String SUFFIX = "java";

    private static final String PATH = "/Users/yangbo/Desktop/ttt";

    public static void main(String[] args) throws IOException {
        IO(PATH);
    }

    /**
     * 1.遍历文件夹下所有.java文件
     * 2.将注解"Service"替换为"Adapter"
     * 3.文件中添加日志引用及接口注入
     * 4.为方法添加返回值
     *
     * @param path 文件夹绝对路径
     */
    private static void IO(String path) throws IOException {
        File[] files = new File(path).listFiles();
        for (File f : files) {
            // 文件名
            String fileName = f.getName();
            // 类名小写
            String min = null;
            // 不是Java文件则跳过本次循环
            if (!SUFFIX.equals(fileName.substring(fileName.length() - 4))) {
                continue;
            }
            PrintWriter pr = new PrintWriter(new FileWriter(f, true), true);
            BufferedReader bf = new BufferedReader(new FileReader(f));
            String str;
            while ((str = bf.readLine()) != null) {
                // 替换注解：@Service("roleApiService")替换为@Service("roleApiAdapter")
                if (str.contains("@Service(")) {

                }

                // 添加日志和注入接口
                if (str.contains("Service {")) {
                    //类名
                    String name = str.split(" ")[2];

                    // 接口名
                    String interfaceName = str.split(" ")[4];

                    // 接口名首字母小写
                    char[] chars = interfaceName.toCharArray();
                    chars[0] += 32;
                    min = String.valueOf(chars);

                    pr.println();
                    pr.println("private final static Logger logger = LoggerFactory.getLogger(" + name + ".class);");
                    pr.println();
                    pr.println("@Resource(name = \"" + min + "\")");
                    pr.println(interfaceName + " " + min + ";");
                    pr.println();
                }

                // 为方法添加返回值
                if (str.contains(") {") && min != null) {
                    // 方法名
                    String methodName = str.split(" ")[2];
                    pr.println();
                    pr.println("return " + min + "." + methodName + "();");
                }

            }
            bf.close();
            pr.close();
        }
    }
}

