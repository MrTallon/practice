package creational;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * 拥有双重校验锁机制的同步锁单例设计模式（懒汉式）
 * 解决在多线程的情况下同时调用 getInstance()
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-05 15:49
 */
public class LockSingleton {
    private static LockSingleton instance;

    private LockSingleton() {
        System.out.println("Singleton is Instantiated.");
    }

    public static LockSingleton getInstance() {
        // 只有在对象未实例的情况下，才添加同步锁校验
        if (instance == null) {
            synchronized (LockSingleton.class) {
                // 被检查两次，因为需要保证在 synchronized 代码块中也进行一次校验
                if (instance == null) {
                    instance = new LockSingleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Something is Done");
    }
}


/**
 * 无锁的线程安全单例模式（饿汉式）
 */
class LockFreeSingleton {
    private static final LockFreeSingleton instance = new LockFreeSingleton();

    private LockFreeSingleton() {
        System.out.println("Singleton is Instantiated");
    }

    public static synchronized LockFreeSingleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("Something is Done");
    }
}

/**
 * 枚举：解决线程同步，防止反序列化
 */
enum Elvis {
    /**
     * 实例
     */
    INSTANCE;
    private final String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}

/**
 * 基于函数式的单例模式
 */
enum FpSingleton {
    /**
     * 实例
     */
    INSTANCE;

    public static Supplier<FpSingleton> getInstance() {
        return () -> FpSingleton.INSTANCE;
    }

    public void doSomething() {
        System.out.println("Something is Done");
    }
}