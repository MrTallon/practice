package optional;

import lombok.Data;

import java.util.Optional;

/**
 * Optional
 *
 * @author YangBo
 * @date 2019/08/09
 */
public class Test {
    public static void main(String[] args) {
        Hobby hobby = new Hobby();
        hobby.setBasketball("篮球");
        User user = new User();
        user.setHobby(hobby);
        User user1 = new User();

        Optional.of(user).map(User::getHobby).ifPresent(System.out::println);
        Optional.of(user1).map(User::getHobby).ifPresent(System.out::println);

        Optional<Hobby> hobby1 = Optional.ofNullable(user).map(User::getHobby);
        System.out.println(hobby1.orElse(null));

        Optional<Integer> integer = Optional.ofNullable(user).map(User::getId);

        System.out.println(integer.orElse(10000));

    }
}

@Data
class User {
    private Integer id;
    private Hobby hobby;
}

@Data
class Hobby {
    private String sing;
    private String jump;
    private String rap;
    private String basketball;
}
