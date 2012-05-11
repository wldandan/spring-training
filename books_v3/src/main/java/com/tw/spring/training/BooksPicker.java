package com.tw.spring.training;

import com.tw.spring.training.service.BookService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class BooksPicker {
  public static void main(String[] args) throws IOException {

      BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
      BookService service = (BookService) beanFactory.getBean("bookService");
      System.out.println(service.getBooks());
  }
}
