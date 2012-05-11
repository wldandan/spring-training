package com.tw.spring.training.service;

import com.tw.spring.training.filter.Filter;
import com.tw.spring.training.model.Book;
import com.tw.spring.training.reader.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/1/12
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class BookService {
    private Reader reader;
    private List<Filter> filters = new ArrayList<Filter>();

    public BookService() {
    }

    public BookService(Reader reader) {
        this.reader = reader;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void addFilter(Filter filter){
        this.filters.add(filter);
    }


    private boolean isAcceptable(Book book){
        for (Filter filter:getFilters()){
            if (!filter.isAcceptable(book)){
                return false;
            }
        }
        return true;
    }

    public List<Book> getBooks(){
        List<Book> originalBooks = null;
        try {
            originalBooks = getReader().getBooks();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        List<Book> expectedBooks = new ArrayList<Book>();

        for(Book book : originalBooks){
            if (isAcceptable(book)){
                expectedBooks.add(book);
            }
        }
        return expectedBooks;
    }
}
