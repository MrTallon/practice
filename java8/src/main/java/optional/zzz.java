package optional;

import java.util.Optional;
import java.util.Scanner;

/**
 * @version v1.0.0
 * @description:
 * @author: yangbo
 * @create: 2019-11-27 11:30
 */
public class zzz {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setId("p1");
        p1.setName("12345");
        Optional.ofNullable(p1.getId()).ifPresent(p -> {
            String s = p.toUpperCase();
            System.out.println(s);
        });

        System.out.println("===================");
        Person p2 = null;
        Person result = Optional.ofNullable(p2).orElse(p1);
        System.out.println(result);

        System.out.println("===================");
        Person p3 = Optional.ofNullable(p2).orElseGet(() -> {
            System.out.println("我是p2为空才执行的方法");
            return new Person("p2id空了", "p2name空了");
        });
        System.out.println(p3);

        System.out.println("===================");
        String s = Optional.of(p1).map(Person::getName).orElse("1");
        System.out.println(s);

        System.out.println("===================");
        Optional<Person> person =
                Optional.of(p1).filter(
                        p -> p.getName() != null &&
                                p.getName().contains("1"));
        System.out.println(person.isPresent());

        System.out.println("===================");


    }

    private static String aaa() {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        if ("2".equals(s)) {

        }
        sc.close();
        return s;
    }
}

class Person {
    private String id;
    private String name;

    public Person() {
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
