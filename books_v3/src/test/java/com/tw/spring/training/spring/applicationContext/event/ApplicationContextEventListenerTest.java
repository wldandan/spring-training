package com.tw.spring.training.spring.applicationContext.event;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/1/12
 * Time: 2:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContextEventListenerTest {

    @Test
    public void testGetMessage(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("test-beans.xml");
        ctx.getBean("emailHandler");
        ctx.getBean("smsHandler");

        String refreshTime = Calendar.getInstance().getTime().toString();
        ctx.publishEvent(new BooksUpdateEvent(" lastRefreshTime: "+ refreshTime));

    }
}
