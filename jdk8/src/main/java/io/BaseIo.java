package io;

import java.io.*;

/**
 * 读写流基础练习
 *
 * @author YangBo
 * @date 2018/11/04
 */
public class BaseIo {
    public static void main(String[] args) throws Exception {
        String path = "/Users/yangbo/lib/code/company/htd/native-cloud-adapter/adapter-impl/src/main/java/cn/htd/usercenter/adapter/impl";
//        adapter(path);
    }

    /**
     * 写入后读取
     * @throws Exception
     */
    private static void testIO() throws Exception {

        PrintWriter pr = new PrintWriter(new FileWriter("/Users/yangbo/Desktop/金庸.txt", true), true);
        pr.println("丐帮帮主乔峰");
        pr.println("灵鹫宫宫主虚竹");
        pr.println("大理皇帝段誉");
        pr.println("燕子坞慕容复");
        pr.println("大元郡主敏敏特穆尔");
        pr.close();

        BufferedReader bf = new BufferedReader(new FileReader("/Users/yangbo/Desktop/金庸.txt"));
        String str;
        while ((str = bf.readLine()) != null) {
            System.out.println(str);
        }
        bf.close();
    }

    /**
     * 删除文件夹及其文件
     *
     * @param folderPath 文件夹完整绝对路径
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定文件夹下所有文件
     *
     * @param path 文件夹完整绝对路径
     */
    private static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                // 先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                // 再删除空文件夹
                delFolder(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }
}
