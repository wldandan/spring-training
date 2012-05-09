package com.tw.spring.training.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/29/12
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class BeanFactory {

    private static BeanFactory instance = new BeanFactory();

    private BeanFactory(){}

    public static BeanFactory getInstance(){
        return instance;
    }

    public Object getBean(String className, Class[] paramTypes, Object[] params)
    {
        Object obj = null;
        try{
            Class cls = Class.forName(className);
            Constructor constructor = cls.getConstructor(paramTypes);
            obj = constructor.newInstance(params);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }

    public Object getBean(String className)
    {
        Object object = null;
        try {
            object = Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public void setAttribute(Object object, String attributeName, Class attributeClass, Object attributeValue){
        String firstLetter = attributeName.substring(0, 1).toUpperCase();
        String methodName = "set" + firstLetter+ attributeName.substring(1);
        try {
            Method method = object.getClass().getMethod(methodName, new Class[]{attributeClass});
            method.invoke(object, new Object[]{attributeValue});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getAttribute(Object object, String attributeName){
        Object value = null;
        String firstLetter = attributeName.substring(0, 1).toUpperCase();
        String methodName = "get" + firstLetter+ attributeName.substring(1);
        try {
            Method method = object.getClass().getMethod(methodName, new Class[]{});
            value = method.invoke(object, new Object[]{});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
