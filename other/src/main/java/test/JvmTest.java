package test;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM 测试类
 * @author yangbo
 * @version v1.0.0
 * @date 2019-12-20 00:33
 */
public class JvmTest {

    public static void main(String[] args) {
        List<Person> pl = new ArrayList<>();

        Person p = null;

        p = new Person();
        p.setName("1");
        pl.add(p);

        p = new Person();
        p.setName("2");
        pl.add(p);

        p = new Person();
        p.setName("3");
        pl.add(p);

        for (Person pp : pl) {
            System.out.println(pp.getName());
        }
    }
}
class Person{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}