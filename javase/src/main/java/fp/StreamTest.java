package fp;

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

    }

    public static void addEmp() {
//        RandomPeople
    }
}

class Emp {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer age;
    private Integer region;
    private Double salary;

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

    public Emp(Integer id, String name, Integer gender, Integer age, Integer region, Double salary) {
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
