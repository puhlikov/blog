package com.epam.training.model;

import java.util.Objects;

/**
 * com.epam.training.model - book
 * @author Pavel Bukhtsiyarau
 */
public class Book {
    /**
     * Book id
     */
    private int id;
    /**
     * Book's name
     */
    private String name;
    /**
     * Book's author
     */
    private String author;
    /**
     * Book's description
     */
    private String description;

    /**
     * Constructor without parameters
     * @param id
     * @param name
     */
    public Book(int id, String name){
    }
    /**
     * Constructor with parameters
     *
     * @param id
     * @param name
     * @param author
     * @param description
     */
    public Book(int id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Book(){
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public int getId() {return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                name.equals(book.name) &&
                author.equals(book.author) &&
                description.equals(book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, description);
    }

    @Override
    public  String toString(){
        return "Book: " + id + ",  " + name + ",  " + author + ", " + description + " .";
    }

}
