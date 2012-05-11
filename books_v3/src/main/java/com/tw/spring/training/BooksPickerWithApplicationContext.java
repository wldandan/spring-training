package com.tw.spring.training;

import com.tw.spring.training.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class BooksPickerWithApplicationContext {
  public static void main(String[] args) throws IOException {

      ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
      System.out.println( ((BookService)ctx.getBean("bookService")).getBooks());

  }
}
