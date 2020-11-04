package structural.adapter.proxy;

/**
 * 需要代理的事件对象
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-04 15:06
 */
public class RealSubject implements Subject{

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayGoodBye() {
        return "good bye";
    }
}
