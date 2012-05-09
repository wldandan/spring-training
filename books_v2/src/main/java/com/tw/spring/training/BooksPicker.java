package com.tw.spring.training;

import com.tw.spring.training.factory.Factory;
import com.tw.spring.training.filter.DiscountFilter;
import com.tw.spring.training.filter.Filter;
import com.tw.spring.training.filter.PriceFilter;
import com.tw.spring.training.model.Book;
import com.tw.spring.training.reader.Reader;
import com.tw.spring.training.service.BookService;

import java.io.IOException;
import java.util.List;

public class BooksPicker {
  public static void main(String[] args) throws IOException {

      Factory factory = new Factory();

      //args[0 is ["File:xxxxxx" or "Url:xxxxx"]
      Reader reader = factory.getReader(args[0]);

      Filter maxPriceFilter = new PriceFilter(200.0);
      Filter minDiscountFilter = new DiscountFilter(0.50);

      BookService service = new BookService(reader);
      service.addFilter(maxPriceFilter);
      service.addFilter(minDiscountFilter);

      List<Book> books = service.getBooks();
      for (Book book: books){
          System.out.println(book.toString());
      }
  }
}
