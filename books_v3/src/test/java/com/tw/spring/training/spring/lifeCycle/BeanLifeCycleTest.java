package com.tw.spring.training.spring.lifeCycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/11/12
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class BeanLifeCycleTest {
    @Test
    public void shouldGetBeanLifeCycle(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-beans-lifecycle.xml");
        ctx.getBean("beanLifeCycle");

    }
}
