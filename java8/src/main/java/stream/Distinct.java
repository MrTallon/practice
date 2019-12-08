package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 根据某一个字段去重(只留下第一次出现的数据)
 */
public class Distinct {
    public static void main(String[] args){
        People p1 = new People(1, "1", 1, "1", "1");
        People p2 = new People(1, "2", 2, "2", "2");
        People p3 = new People(1, "3", 3, "3", "3");
        List<People> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        List<People> distictList = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(People::getId))), ArrayList::new));
        System.out.println(distictList);
    }

}
