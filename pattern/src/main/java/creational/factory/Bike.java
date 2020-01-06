package creational.factory;

/**
 * 自行车
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-06 22:53
 */
public class Bike extends Vehicle {
    @Override
    public Vehicle newInstance() {
        return new Bike();
    }
}
