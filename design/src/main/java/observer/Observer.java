package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * 对象间一对多的依赖关系，
 * 当一个对象的状态发生改变时，
 * 所有依赖于它的对象都得到通知并被自动更新。
 *
 * @author YangBo
 * @date 2019/03/15
 */
class Observer {
    List<Person> list = new ArrayList<>();

    void addPersion(Person person) {
        list.add(person);
    }

    /**
     * 遍历list，把自己的通知发给所有的关注者
     */
    void notifyPerson() {
        for (Person person : list) {
            person.getMessage("所有观察者收到通知");
        }
    }

}
