package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Apple
 *
 * @author YangBo
 * @date 2019/07/04
 */
@Data
@AllArgsConstructor
public class Apple {
    private String color;
    private Double weight;
}


class FiliterApple{
    public static void main(String[] args){
        // 苹果集合
        List<Apple> apples = Arrays.asList(new Apple("绿", 150d), new Apple("绿", 180d));
        Comparator<Apple> byColor = Comparator.comparing(Apple::getColor);
    }
}