package com.tw.spring.training.spring.applicationContext.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/1/12
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SMSEventHandler implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof BooksUpdateEvent){
            System.out.println("the handler will send update by SMS");
        }
    }
}
