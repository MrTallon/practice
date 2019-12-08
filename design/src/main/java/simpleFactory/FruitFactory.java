package simpleFactory;

/**
 * 简单工厂模式的水果工厂
 *
 * @author YangBo
 * @date 2019/04/23
 */
public class FruitFactory {

    public static Fruit getFruit(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // 扩展性强，实用性弱。因为想要使用它必须清楚完整的类名
        Class fruit = Class.forName(type);
        return (Fruit) fruit.newInstance();
    }


}
