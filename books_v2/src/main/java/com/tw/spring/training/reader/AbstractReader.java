package com.tw.spring.training.reader;

import com.tw.spring.training.model.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/8/12
 * Time: 11:27 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractReader implements Reader{
    @Override
    public abstract InputStream read() throws IOException;

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        try {
            Scanner scanner = new Scanner(read());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                books.add(parseBook(line));
            }
        } catch (IOException e) {
        }
        return books;
    }


    protected Book parseBook(String line) {
        String[] attributes = line.split(",");
        Book book = new Book();
        book.setIsbn(attributes[0].trim());
        book.setName(attributes[1].trim());
        book.setPrice(Double.valueOf(attributes[2].trim()));
        book.setDiscount(Double.valueOf(attributes[3].trim()));
        return book;
    }
}
