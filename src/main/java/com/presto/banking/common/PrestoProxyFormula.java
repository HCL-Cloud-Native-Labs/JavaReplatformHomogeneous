package com.presto.banking.common;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
class PrestoProxyFormula {
    public static void proxyFocusCheck() {
        Object o = null;
        try {
            o = Proxy.newProxyInstance(PrestoProxyFormula.class.getClassLoader(), null, null);
        } catch (NullPointerException e) {
            System.out.println("newProxyInstance OK");
        }
        try {
            o = Proxy.getProxyClass(PrestoProxyFormula.class.getClassLoader(), new Class[0]).getConstructor(new Class[]{ InvocationHandler.class }).newInstance(new Object[1]);
            System.out.println("Oops, created proxy instance without handler");
        } catch (NullPointerException e) {
            System.out.println("Proxy constructor OK");
        } catch (Exception e) {
            System.out.println("shouldn't get here");
        }
        if (o != null)
            try {
                System.out.println(o);
            } catch (NullPointerException e) {
                System.out.println("Delayed failure is BAD");
                e.printStackTrace();
            }

    }
}