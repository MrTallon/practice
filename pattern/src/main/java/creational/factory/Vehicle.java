package creational.factory;

/**
 * 车辆
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-06 22:52
 */
public abstract class Vehicle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }

    public abstract Vehicle newInstance();
}
