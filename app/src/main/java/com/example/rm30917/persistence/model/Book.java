package com.example.rm30917.persistence.model;

/**
 * Created by RM30917 on 12/12/2016.
 */
public class Book {

    public static final String TABLE_NAME = "books";
    public static final String ID = "_id";
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String COMPANY = "company";

    private int id;
    private String title;
    private String author;
    private String company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
