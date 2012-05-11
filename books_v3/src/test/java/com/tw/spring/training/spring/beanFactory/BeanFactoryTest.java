package com.tw.spring.training.spring.beanFactory;

import com.tw.spring.training.service.BookService;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/10/12
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class BeanFactoryTest {

    @Test
    public void testGetBeanFactorytByClassPathResource(){
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Assert.assertNotNull(factory);

        BookService bookservice = (BookService) factory.getBean("bookService");
        Assert.assertTrue(bookservice.getBooks().size() > 0);
    }

    @Test
    public void testGetApplicationContextByFileSystemResource(){
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("/Users/twer/Work/pratice/spring/books_v3/src/main/resources/beans.xml"));
        Assert.assertNotNull(factory);

        BookService bookservice = (BookService) factory.getBean("bookService");
        Assert.assertTrue(bookservice.getBooks().size() > 0);
    }

    @Test
    public void testGetBeanFactoryByBeanDefinitionReader(){
        BeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Assert.assertNotNull(factory);

        BookService bookservice = (BookService) factory.getBean("bookService");
        Assert.assertTrue(bookservice.getBooks().size() > 0);
    }

}
