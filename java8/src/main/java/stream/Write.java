package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @description:
 * @author: yangbo
 * @create: 2019-10-29 16:56
 */
public class Write {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("第一行代码\n");
        list.add("第二行代码\n");
        Files.write(Paths.get("write.txt"), list, StandardOpenOption.CREATE);
    }
}
