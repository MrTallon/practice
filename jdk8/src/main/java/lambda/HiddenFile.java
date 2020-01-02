package lambda;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 查找一个文件夹所有的隐藏文件
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class HiddenFile {
    public static void main(String[] args) {
        String path = "/Users/yangbo/lib/code/company/htd/native-cloud-adapter/adapter-impl/src/main/java/cn/htd/usercenter/adapter/api";
        normal(path);
    }

    /**
     * 查询目录下的隐藏文件夹
     *
     * @param path
     */
    private static void hidden(String path) {
        File[] hidden = new File(path).listFiles(File::isHidden);
        for (File f : hidden) {
            System.out.println(f.getName());
        }
    }

    private static void normal(String path) {
        File[] hidden = new File(path).listFiles();
        for (File f : hidden) {
            String[] split = f.getName().split(".j");
            System.out.println(split[0]);
        }
    }

    public static void newMethod(String path) throws Exception {
        Path start = FileSystems.getDefault().getPath(path);
        Files.walk(start).filter(childpath -> childpath.toFile().isFile())
                // .filter(path -> path.toString().endsWith(EndName))
                .forEach(System.out::println);
    }

    /**
     * 通过文件路径直接修改文件名
     *
     * @param filePath    需要修改的文件的完整路径
     * @param newFileName 需要修改的文件的名称
     * @return
     */
    private String FixFileName(String filePath, String newFileName) {
        File f = new File(filePath);
        if (!f.exists()) { // 判断原文件是否存在（防止文件名冲突）
            return null;
        }
        newFileName = newFileName.trim();
        if ("".equals(newFileName) || newFileName == null) { // 文件名不能为空
            return null;
        }
        String newFilePath = null;
        if (f.isDirectory()) { // 判断是否为文件夹
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName;
        } else {
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName
                    + filePath.substring(filePath.lastIndexOf("."));
        }
        File nf = new File(newFilePath);
        try {
            f.renameTo(nf); // 修改文件名
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        }
        return newFilePath;
    }

}
