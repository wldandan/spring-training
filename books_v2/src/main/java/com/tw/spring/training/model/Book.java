package com.tw.spring.training.model;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/29/12
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */

public class Book {
    private String isbn;
    private String name;
    private Double price;
    private Double discount;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIsbn() {

        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString(){
        return "|ISBN:"+this.getIsbn()
              +"|Name:"+this.getName()
              +"|Price:"+this.getPrice()
              +"|Discount:"+this.getDiscount()
              +"|FinalPrice:"+this.price * (1 - this.getDiscount())
              +"|";
    }
}
