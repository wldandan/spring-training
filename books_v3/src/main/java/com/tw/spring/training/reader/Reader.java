package com.tw.spring.training.reader;

import com.tw.spring.training.model.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * This is a base interface contract for any data reading functionality. Ideally
 * the read method implements the technical details of how the data is read.
 * 
 * @author kondama
 * 
 */
public interface Reader {
  public InputStream read() throws IOException;
  public List<Book> getBooks();
}
