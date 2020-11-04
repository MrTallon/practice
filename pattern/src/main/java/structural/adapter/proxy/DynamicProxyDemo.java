package structural.adapter.proxy;

import java.lang.reflect.Proxy;

/**
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-04 15:05
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println("动态代理对象的类型: " + subject.getClass().getName());
        String hello = subject.sayHello("tallon");
        System.out.println(hello);
    }
}
