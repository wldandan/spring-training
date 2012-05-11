package com.tw.spring.training.spring.applicationContext;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/10/12
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContextTest {

    @Test
    public void testGetApplicationContextByClassPath(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Assert.assertNotNull(ctx);
    }

    @Test
    public void testGetApplicationContextByFileSystem(){
        ApplicationContext ctx = new FileSystemXmlApplicationContext("//Users/twer/Work/pratice/spring/books_v3/src/main/resources/beans.xml");
        Assert.assertNotNull(ctx);
    }
}
