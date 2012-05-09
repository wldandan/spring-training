package com.tw.spring.training.reader;

import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/30/12
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileReaderTest {

    String file = "/Users/twer/Work/pratice/spring/books_v2/books.csv";
    Reader reader = new FileReader(file);

    @Test
    public void testOpenLocalFile(){
        try {
            InputStream inputStream = reader.read();
            Assert.assertNotNull(inputStream);
            Assert.assertTrue(inputStream.available() > 0);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
