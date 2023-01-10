package com.librarymanagement.components.book.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class BookItem {
    private Long id;
    private Date publihsedDate;
    private int format;
    private String publisher;
    private int numberOfPages;
    private double price;
    private long bookId;
    private Instant dateAdded;
    private Instant dateModified;
    private boolean available;
    private boolean deleted;
    public BookItem() {
    }
    public BookItem(Long id, Date publihsedDate, int format, String publisher, int numberOfPages, double price, long bookId, Instant dateAdded, Instant dateModified, boolean available, boolean deleted) {
        this.id = id;
        this.format = format;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bookId = bookId;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.available = available;
        this.deleted = deleted;
    }

    public static BookItem parse(ResultSet rs) throws SQLException {
        Long id= rs.getLong("id");
        Date publihsedDate = rs.getDate("publishedDate");
        int format = rs.getInt("format");
        String publisher = rs.getString("publisher");
        int numberOfPages = rs.getInt("numberOfPages");
        double price = rs.getDouble("price");
        long bookId = rs.getLong("bookId");
        Instant dateAdded = rs.getTimestamp("dateAdded").toInstant();
        Instant dateModified = rs.getTimestamp("dateModified").toInstant();
        boolean available= rs.getBoolean("available");
        boolean deleted= rs.getBoolean("deleted");
        return new BookItem(id, publihsedDate, format, publisher, numberOfPages, price, bookId, dateAdded, dateModified, available, deleted);
    }

    public Date getPublihsedDate() {
        return publihsedDate;
    }

    public void setPublihsedDate(Date publihsedDate) {
        this.publihsedDate = publihsedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Instant getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Instant dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Instant getDateModified() {
        return dateModified;
    }

    public void setDateModified(Instant dateModified) {
        this.dateModified = dateModified;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
