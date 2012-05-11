package com.tw.spring.training.spring.applicationContext.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/1/12
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class BooksUpdateEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never <code>null</code>)
     */
    public BooksUpdateEvent(Object source) {
        super(source);
    }
}
