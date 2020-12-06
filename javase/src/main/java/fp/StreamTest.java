package fp;

import other.RandomPeople;
import other.UniqueNum;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式编程
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-12-05 17:55
 */
public class StreamTest {

    private static List<Emp> empList = new ArrayList<>(1000);


    public static void main(String[] args) {
        addEmp();
    }

    public static void addEmp() {
        Emp e = new Emp();
        e.setId(UniqueNum.num());
        String name = RandomPeople.getName();
        e.setName(name.split("-")[2]);
        e.setAge(name.split("-")[1].equals("男") ? 0 : 1);
        e.setRegion();
        String phone = RandomPeople.getTel();
        System.out.println(name);

    }
}

class Emp {
    private Long id;
    private String name;
    private Integer gender;
    private Integer age;
    private Integer region;
    private Double salary;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Emp() { }

    public Emp(Long id, String name, Integer gender, Integer age, Integer region, Double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.region = region;
        this.salary = salary;
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
