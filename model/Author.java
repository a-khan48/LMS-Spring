package com.example.library.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}