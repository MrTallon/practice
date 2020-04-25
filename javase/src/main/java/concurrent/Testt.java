package concurrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * test
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-04-09 10:22
 */
public class Testt {
    public static void main(String[] args) {
        List<Hello> list = new ArrayList<>();
        list.add(new Hello(null, "hyh"));
        list.add(new Hello(1, "qwe"));
        list.add(new Hello(2, "123"));
        List<Hello> collect = list.stream().filter(r -> r.getId() != null).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    /**
     * 计算比率
     */
    private static BigDecimal realCountDecimal(int preNum, int sufNum) {
        if (preNum == sufNum) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf((sufNum - preNum) * 100).divide(BigDecimal.valueOf(preNum), 2, BigDecimal.ROUND_HALF_DOWN);
    }
}

class Hello{
    private Integer id;
    private String name;

    public Hello(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



