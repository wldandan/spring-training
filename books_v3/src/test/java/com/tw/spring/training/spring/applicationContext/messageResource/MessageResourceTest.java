package com.tw.spring.training.spring.applicationContext.messageResource;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/30/12
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class MessageResourceTest {

    @Test
    public void testGetMessageByEng(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Assert.assertEquals(ctx.getMessage("hello.message", null, null), "Hello! You are using English version.") ;
    }

    @Test
    public void testGetMessageByChinese(){
        ApplicationContext ctx = new FileSystemXmlApplicationContext("//Users/twer/Work/pratice/spring/books_v3/src/main/resources/beans.xml");
        Assert.assertEquals(ctx.getMessage("hello.message",null,new Locale("zh", "CN")), "xxxxx. You are using Chinese version.") ;
    }


}
