package com.tw.spring.training.reflection;

import com.tw.spring.training.model.Book;
import junit.framework.Assert;
import org.junit.Test;
import java.lang.reflect.*;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/9/12
 * Time: 12:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class BookReflectionTest {

    @Test
    public void createAnObjectOfBookByDefaultConstructor(){
        Book book = null;
        try {
            book = (Book)Class.forName("com.tw.spring.training.model.Book").newInstance();
            Assert.assertTrue(book instanceof Book);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void createAnObjectOfBookByCustomizedConstructor(){
        try {
            Class cls = Class.forName("com.tw.spring.training.model.Book");
            Constructor constructor = cls.getConstructor(new Class[]{String.class, String.class, Double.class, Double.class});
            Book book = (Book) constructor.newInstance(new Object[]{"200-01B","Java in action",100.0, 0.60});
            Assert.assertTrue(book instanceof Book);

            Assert.assertEquals(book.getIsbn(), "200-01B");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void getFieldsOfBook(){
        try {
            Class cls = Class.forName("com.tw.spring.training.model.Book");
            Constructor constructor = cls.getConstructor(new Class[]{String.class, String.class, Double.class, Double.class});
            Book book = (Book) constructor.newInstance(new Object[]{"200-01B","Java in action",100.0, 0.60});
            Assert.assertTrue(book instanceof Book);

            Assert.assertTrue(book.getClass().getDeclaredFields().length > 0);

            Field field = book.getClass().getDeclaredField("name");
            Assert.assertEquals(field.getGenericType(), String.class);
            Assert.assertEquals(field.isAccessible(), false);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void getMethodsOfBook(){
        try {
            Class cls = Class.forName("com.tw.spring.training.model.Book");
            Constructor constructor = cls.getConstructor(new Class[]{String.class, String.class, Double.class, Double.class});
            Book book = (Book) constructor.newInstance(new Object[]{"200-01B","Java in action",100.0, 0.60});
            Assert.assertTrue(book instanceof Book);

            Assert.assertTrue(book.getClass().getDeclaredMethods().length > 0);

            Method method = book.getClass().getMethod("getName", new Class[]{});
            String value = (String)method.invoke(book, new Object[]{});
            Assert.assertEquals(value, "Java in action");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void setMethodsOfBook(){
        try {
            Class cls = Class.forName("com.tw.spring.training.model.Book");
            Constructor constructor = cls.getConstructor(new Class[]{String.class, String.class, Double.class, Double.class});
            Book book = (Book) constructor.newInstance(new Object[]{"200-01B","Java in action",100.0, 0.60});
            Assert.assertTrue(book instanceof Book);

            Assert.assertTrue(book.getClass().getDeclaredMethods().length > 0);

            Method method = book.getClass().getMethod("getName", new Class[]{});
            String value = (String)method.invoke(book, new Object[]{});
            Assert.assertEquals(value, "Java in action");

            method = book.getClass().getMethod("setName", new Class[]{String.class});
            method.invoke(book, new Object[]{"Java Programming"});

            method = book.getClass().getMethod("getName", new Class[]{});
            value = (String)method.invoke(book, new Object[]{});
            Assert.assertEquals(value, "Java Programming");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
