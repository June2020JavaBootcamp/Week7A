package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "isbn")
    private String bookISBN;

    @Column(name = "title")
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @ManyToOne
    private Category category;

    @Column(name = "quantity")
    private int bookQuantity;

    @Column(name = "year")
    private int bookYear;

    @Column(name = "image")
    private String bookImage;

    @Column(name = "inStock")
    private boolean bookInStock;


    public Book() {
    }

    public Book(String bookISBN, String bookTitle, String bookAuthor, int bookQuantity, int bookYear, String bookImage, boolean bookInStock) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQuantity = bookQuantity;
        this.bookYear = bookYear;
        this.bookImage = bookImage;
        this.bookInStock = bookInStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public boolean isBookInStock() {
        return bookInStock;
    }

    public void setBookInStock(boolean bookInStock) {
        this.bookInStock = bookInStock;
    }
}
