package fp;

import other.RandomPeople;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流式编程
 * https://zhuanlan.zhihu.com/p/285237824
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-12-05 17:55
 */
public class StreamTest {

    private static List<Emp> empList = new ArrayList<>(1000);


    public static void main(String[] args) {
        addEmp();
        /*
        将员工按薪资从高到低排序，同样薪资者年龄小者在前。
        将员工按性别分类，将员工按性别和地区分类，将员工按薪资是否高于8000分为两部分。
         */
        // 大于8000的员工
        List<Emp> highSalary = empList.stream().filter(e -> e.getSalary() > 8000).collect(Collectors.toList());
        System.out.println("薪资大于8000的员工数" + highSalary.size());

        // 求员工总数
        long count = empList.size();
        // 求平均工资
        Double average = empList.stream().collect(Collectors.averagingDouble(Emp::getSalary));
        // 求最高工资
        Optional<Integer> max = empList.stream().map(Emp::getSalary).max(Integer::compare);
        // 求工资之和
        int sum = empList.stream().mapToInt(Emp::getSalary).sum();
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = empList.stream().collect(Collectors.summarizingDouble(Emp::getSalary));

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工最高工资：" + max.get());
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);

        // 按工资增序排序
        List<String> lsit1 = empList.stream().sorted(Comparator.comparing(Emp::getSalary)).map(Emp::getName).collect(Collectors.toList());

        // 按工资倒序排序
        List<String> list2 = empList.stream().sorted(Comparator.comparing(Emp::getSalary).reversed()).map(Emp::getName).collect(Collectors.toList());

        // 先按工资再按年龄自然排序（从小到大）
        List<String> list3 = empList.stream().sorted(Comparator.comparing(Emp::getSalary).reversed()).map(Emp::getName).collect(Collectors.toList());

        // 先按工资再按年龄自定义排序（从大到小）
        List<String> list4 = empList.stream().sorted((p1, p2) -> {
            if (p1.getSalary().equals(p2.getSalary())) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Emp::getName).collect(Collectors.toList());

    }

    public static void test1() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);
    }

    public static void addEmp() {
        Emp e;
        for (int i = 1; i <= 1000; i++) {
            e = new Emp();
            e.setId((long) i);
            String[] info = RandomPeople.getInfoDetail().split("-");
            e.setName(info[0]);
            e.setGender(info[1]);
            e.setAge(Integer.valueOf(info[2]));
            e.setRegion(info[3]);
            e.setSalary(RandomPeople.getNum(3000, 10000));
            empList.add(e);
        }
    }
}

class Emp {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String region;
    private Integer salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", region=" + region +
                ", salary=" + salary +
                '}';
    }
}
