package com.tw.spring.training.filter;

import com.tw.spring.training.model.Book;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/4/12
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Filter {
    public boolean isAcceptable(Book book);
}
