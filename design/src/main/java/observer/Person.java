package observer;

/**
 * 观察者接口
 *
 * @author YangBo
 * @date 2019/03/15
 */
public interface Person {
    void getMessage(String s);
}

/**
 * Eric
 */
class Eric implements Person {
    private String name = "Eric";

    @Override
    public void getMessage(String s) {
        System.out.println("收到的消息是 ： " + s);
    }
}

class Tallon implements Person {
    private String name = "Tallon";

    @Override
    public void getMessage(String s) {
        System.out.println("收到的消息是 ： " + s);
    }
}
