package com.tw.spring.training.filter;

import com.tw.spring.training.model.Book;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/4/12
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class PriceFilter implements Filter {

    private double maxPrice;

    public PriceFilter(){
    }

    public PriceFilter(double maxPrice){
        this.maxPrice = maxPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean isAcceptable(Book book) {
        return (book.getPrice() <= maxPrice);
    }
}
