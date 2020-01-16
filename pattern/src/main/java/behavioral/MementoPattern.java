package behavioral;

/**
 * 备忘录模式
 * <p>
 * 目的：用于保存对象的内部状态而不破坏其封装，并在以后阶段恢复其状态
 * 适用情况：用于各种原子事物，需要回滚操作的场景
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-15 22:11
 */
public class MementoPattern {
    public static void main(String[] args) {
        new MementoPattern().runMechanicTest();
    }

    private void runMechanicTest() {
        CarOriginator.Memento savedState;
        CarOriginator originator = new CarOriginator();
        originator.setState("State1");
        originator.setState("State2");
        savedState = originator.saveState();
        originator.setState("State3");
        originator.restoreState(savedState);
        System.out.println("final state: " + originator.getState());
    }
}

/**
 * 汽车服务程序
 * 机械师测试每辆车，使用自动装置测量汽车的所有输出，以获得不同的参数
 * 执行所有的测试并必须重新检查可疑的测试
 */
class CarOriginator {
    private String state;

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

    Memento saveState() {
        return new Memento(this.state);
    }

    void restoreState(Memento memento) {
        this.state = memento.getState();
    }

    static class Memento {
        private String state;

        Memento(String state) {
            this.state = state;
        }

        private String getState() {
            return state;
        }
    }
}

