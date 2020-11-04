package structural.adapter.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用处理器的实现类
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-04 15:07
 */
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 要代理的真实对象
     */
    private Object subject;

    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("调用之前执行");
        System.out.println("Method: " + method);
        Object returnValue = method.invoke(subject, args);
        System.out.println("调用之后执行");
        return returnValue;
    }
}
