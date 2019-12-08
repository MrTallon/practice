package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


/**
 * @author yangbo
 */
public class Write {
    public static void main(String[] args) throws IOException {
        List<String> list1 = new ArrayList<>();
        list1.add("第一行代码\n");
        list1.add("第二行代码\n");
        Files.write(Paths.get("write.txt"), list1, StandardOpenOption.CREATE);


        List<String> list = new ArrayList<>();
        list.add("第🈚️行数据\n");
//        list.add("第二行数据\n");
//        list.add("第三行数据\n");
        Files.write(Paths.get("write.txt"), list, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
