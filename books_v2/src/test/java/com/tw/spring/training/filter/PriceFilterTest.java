package com.tw.spring.training.filter;

import com.tw.spring.training.model.Book;
import junit.framework.Assert;
import org.junit.Test;
/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/9/12
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PriceFilterTest {

    @Test
    public void shouldNotAccept(){
        Book book = new Book();
        book.setPrice(500.0);
        book.setDiscount(0.51);
        PriceFilter priceFilter = new PriceFilter(200);
        Assert.assertFalse(priceFilter.isAcceptable(book));
    }

    @Test
    public void shouldAccept(){
        Book book = new Book();
        book.setPrice(500.0);
        book.setDiscount(0.8);
        PriceFilter priceFilter = new PriceFilter(200);
        Assert.assertFalse(priceFilter.isAcceptable(book));
    }
}
