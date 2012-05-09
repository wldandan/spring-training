package com.tw.spring.training.service;

import com.tw.spring.training.factory.Factory;
import com.tw.spring.training.filter.DiscountFilter;
import com.tw.spring.training.filter.Filter;
import com.tw.spring.training.filter.PriceFilter;
import com.tw.spring.training.model.Book;
import com.tw.spring.training.reader.Reader;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/9/12
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookServiceTest {

    @Test
    public void shouldGetBooksFromFile(){

        Factory factory = new Factory();

        //args[0 is ["File:xxxxxx" or "Url:xxxxx"]
        Reader reader = factory.getReader("File:/Users/twer/Work/pratice/spring/books_v2/books.csv");

        Filter maxPriceFilter = new PriceFilter(200.0);
        Filter minDiscountFilter = new DiscountFilter(0.50);

        BookService service = new BookService(reader);
        service.addFilter(maxPriceFilter);
        service.addFilter(minDiscountFilter);

        List<Book> books = service.getBooks();
        Assert.assertEquals(books.size(), 4);
    }

    @Test
    public void shouldGetBooksFromUrl(){

        Factory factory = new Factory();

        //args[0 is ["File:xxxxxx" or "Url:xxxxx"]
        Reader reader = factory.getReader("Url:http://10.29.2.117:8080/books/books.csv");

        Filter maxPriceFilter = new PriceFilter(200.0);
        Filter minDiscountFilter = new DiscountFilter(0.50);

        BookService service = new BookService(reader);
        service.addFilter(maxPriceFilter);
        service.addFilter(minDiscountFilter);

        List<Book> books = service.getBooks();
        Assert.assertEquals(books.size(), 4);
    }
}
