package observer;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/03/15
 */
public class Test {
    public static void main(String[] args) {
        //两个观察者
        Person a = new Eric();
        Person b = new Tallon();
        //注册观察者
        Observer o = new Observer();
        o.addPersion(a);
        o.addPersion(b);
        //发送消息
        o.notifyPerson();
    }

}
