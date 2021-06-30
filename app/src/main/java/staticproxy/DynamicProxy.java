package staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private DAOInterface daoInterface;

    public DAOInterface getProxy(DAOInterface daoInterface){
        this.daoInterface=daoInterface;
        return (DAOInterface) Proxy.newProxyInstance(daoInterface.getClass().getClassLoader(),
                daoInterface.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(daoInterface, args);
        return invoke;
    }
}
