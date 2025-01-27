package com.librarymanagement.components.book.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class Book {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String subject;
    private String language;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean available;
    private boolean deleted;

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book() {
    }

    public Book(Long id, String isbn, String title, String author, String subject, String language, Instant createdAt, Instant updatedAt, boolean available,boolean isDeleted) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.language = language;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.available = available;
        this.deleted = isDeleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Book(String title, String isbn, String author, String subject, String language) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.subject = subject;
        this.language = language;
    }

    public static Book parse(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String isbn = rs.getString("isbn");
        String title = rs.getString("title");
        String author = rs.getString("author");
        String subject = rs.getString("subject");
        String language = rs.getString("language");
        Instant dateAdded = rs.getTimestamp("dateAdded").toInstant();
        Instant dateModified = rs.getTimestamp("dateModified").toInstant();
        boolean isAvailable = rs.getBoolean("available");
        boolean isDeleted = rs.getBoolean("deleted");
        return new Book(id,isbn, title, author,subject,language,dateAdded,dateModified,isAvailable,isDeleted);
    }


//    public static Book parse(ResultSet rs) {
//        long id = rs.getLong('id');
//        String ISBN = fields[1];
//        String title = fields[2];
//        String author = fields[3];
//        String subject = fields[4];
//        String language = fields[5];
//        return new Book(id, ISBN, title, author, subject, language, createdAt, updatedAt);
//    }

    public long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                id, isbn, title, author, subject, language, createdAt, updatedAt);
    }

    public String getPreview() {
        return String.format("Tiêu đề: %s, ISBN: %s, Tác giả: %s, Chủ đề: %s, Ngôn ngữ: %s", title, isbn, author, subject, language);
    }
}