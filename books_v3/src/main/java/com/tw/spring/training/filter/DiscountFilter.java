package com.tw.spring.training.filter;

import com.tw.spring.training.model.Book;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/4/12
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiscountFilter implements Filter {

    private double minDiscount;

    public DiscountFilter()
    {
    }

    public DiscountFilter(double minDiscount)
    {
        this.minDiscount = minDiscount;
    }

    public double getMinDiscount() {
        return minDiscount;
    }

    public void setMinDiscount(double minDiscount) {
        this.minDiscount = minDiscount;
    }

    @Override
    public boolean isAcceptable(Book book) {
        return (book.getDiscount() >=  minDiscount);
    }
}
