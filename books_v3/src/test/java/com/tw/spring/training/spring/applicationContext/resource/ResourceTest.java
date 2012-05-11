package com.tw.spring.training.spring.applicationContext.resource;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/11/12
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void shouldGetResourceFromFile(){
        Resource resource = ctx.getResource("file:/Users/twer/Work/pratice/spring/books_v3/src/main/resources/beans.xml");
        try {
            Assert.assertNotNull(resource.getInputStream());
            Assert.assertTrue(resource.getInputStream().available() > 0);
        } catch (IOException e) {
        }

    }

    public void shouldGetResourceFromUrl(){
        Resource resource = ctx.getResource("url:http:///testing.txt");
        try {
            Assert.assertNotNull(resource.getInputStream());
            Assert.assertTrue(resource.getInputStream().available() > 0);
        } catch (IOException e) {
        }
    }

    public void shouldGetResourceFromClassPath(){
        Resource resource = ctx.getResource("classpath:config.properties");
        try {
            Assert.assertNotNull(resource.getInputStream());
            Assert.assertTrue(resource.getInputStream().available() > 0);
        } catch (IOException e) {
        }
    }
}
