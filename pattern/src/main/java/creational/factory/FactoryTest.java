package creational.factory;

/**
 * 工厂测试类
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-06 23:02
 */
public class FactoryTest {
    public static void main(String[] args) {
        SimpleVehicleFactory factory = new SimpleVehicleFactory();
        factory.registerVehicle("car", new Car());
        Car car = (Car) factory.createVehicle("car");
        System.out.println(car);
    }
}
