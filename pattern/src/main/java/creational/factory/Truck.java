package creational.factory;

/**
 * 卡车
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-06 22:54
 */
public class Truck extends Vehicle {
    @Override
    public Vehicle newInstance() {
        return new Truck();
    }
}
