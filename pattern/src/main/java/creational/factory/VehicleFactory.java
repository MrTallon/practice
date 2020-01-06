package creational.factory;

/**
 * 抽象工厂类
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-06 23:12
 */
public abstract class VehicleFactory {
    protected abstract Vehicle createVehicle(String item);

    public Vehicle orderVehicle(String size, String color) {
        Vehicle vehicle = createVehicle(size);
        // TODO
        return null;
    }
}
