package com.tw.spring.training.spring.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/11/12
 * Time: 1:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean, BeanPostProcessor {

    public BeanLifeCycle(){
        System.out.println("Constructor for BeanLifeCycle!");
    }

    public void init(){
        System.out.println("init for BeanLifeCycle!");
    }

    public void destroy(){
        System.out.println("destroy for BeanLifeCycle!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet for BeanLifeCycle!");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization for " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization for " + beanName);
        return bean;
    }


}
