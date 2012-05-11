package com.tw.spring.training.factory;

import com.tw.spring.training.reader.Reader;
import com.tw.spring.training.service.BookService;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/11/12
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BeanFactoryTest {

    @Test
    public void shouldGetService() throws IOException, NoSuchFieldException {
        BeanFactory beanFactory = BeanFactory.getInstance();

        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/config.properties"));
        //this.getClass().getClassLoader().getResourceAsStream("config.properties");

        BookService bookService = (BookService) beanFactory.getBean(properties.getProperty("service.class"));
        Object readerPramClass = beanFactory.getBean(properties.getProperty("service.reader.param.class"));
        Object readerParamObject = properties.getProperty("service.reader.param");
        Reader fileReader = (Reader) beanFactory.getBean(properties.getProperty("service.reader.class"),
                            new Class[]{readerPramClass.getClass()}, new Object[]{readerParamObject});

        Assert.assertNotNull(bookService);
        Assert.assertNotNull(fileReader);

        //Here you should parse the exact property name by config file
        Field field = bookService.getClass().getDeclaredField("reader");
        beanFactory.setAttribute(bookService, field.getName(), field.getType(),fileReader);
        Assert.assertNotNull(bookService.getReader());
    }
}
