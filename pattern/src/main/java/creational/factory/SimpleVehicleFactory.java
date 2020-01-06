package creational.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工程模式
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-06 22:55
 */
public class SimpleVehicleFactory {
    /**
     * 保存对象的ID及对应的Vehicle
     */
    private Map<String, Vehicle> map = new HashMap<>();

    /**
     * 通过实例注册一种新的Vehicle
     * @param vehicleId ID
     * @param vehicle Vehicle
     */
    public void registerVehicle(String vehicleId,Vehicle vehicle){
        map.put(vehicleId, vehicle);
    }

    public Vehicle createVehicle(String vehicleId) {
        return map.get(vehicleId).newInstance();
    }
}
