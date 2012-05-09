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
public class DiscountFilterTest {
    @Test
    public void shouldNotAccept(){
        Book book = new Book();
        book.setPrice(30.0);
        book.setDiscount(0.2);
        DiscountFilter discountFilter = new DiscountFilter(0.5);
        Assert.assertFalse(discountFilter.isAcceptable(book));
    }

    @Test
    public void shouldAccept(){
        Book book = new Book();
        book.setPrice(30.0);
        book.setDiscount(0.3);
        DiscountFilter discountFilter = new DiscountFilter(0.2);
        Assert.assertTrue(discountFilter.isAcceptable(book));
    }

}
