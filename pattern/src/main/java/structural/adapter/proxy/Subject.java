package structural.adapter.proxy;

/**
 * 需要动态代理的接口
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-04 15:05
 */
public interface Subject {
    String sayHello(String name);

    String sayGoodBye();
}
