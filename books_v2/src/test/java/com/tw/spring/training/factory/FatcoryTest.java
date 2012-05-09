package com.tw.spring.training.factory;

import com.tw.spring.training.reader.*;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/9/12
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FatcoryTest {

    @Test
    public void shouldGetFileReader(){
        Factory factory = new Factory();
        Reader reader = factory.getReader("File:/Users/twer/Work/pratice/spring/books_v2/books.csv");
        Assert.assertTrue(reader instanceof FileReader);
    }

    @Test
    public void shouldGetUrlReader(){
        Factory factory = new Factory();
        String url = "Url:http://localhost:8080/books/books.csv";
        Reader reader = factory.getReader(url);
        Assert.assertTrue(reader instanceof UrlReader);
    }
}
