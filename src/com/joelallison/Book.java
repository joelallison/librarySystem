package com.joelallison;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private boolean outOfLib;

    public Book(){

    }

    public Book(String title, String author, String isbn, String genre, boolean outOfLib) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.outOfLib = false;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isOutOfLib() {
        return outOfLib;
    }

    public void setOutOfLib(boolean outOfLib) {
        this.outOfLib = outOfLib;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
