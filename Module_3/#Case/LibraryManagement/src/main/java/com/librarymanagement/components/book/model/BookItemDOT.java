package com.librarymanagement.components.book.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class BookItemDOT {
    private Long id;
    private Date publishedDate;
    private long bookId;
    private String format;
    private String publisher;
    private int numberOfPages;
    private double price;
    private String title;
    private int quantity;
    private Instant dateAdded;
    private Instant dateModified;
    private boolean available;
    private boolean deleted;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public BookItemDOT(Long id, String title, long bookId, Date publishedDate, String format, String publisher, int numberOfPages, double price, int quantity, Instant dateAdded, Instant dateModified, boolean available, boolean deleted) {
        this.id = id;
        this.publishedDate = publishedDate;
        this.format = format;
        this.bookId = bookId;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.title = title;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.available = available;
        this.deleted = deleted;
    }

    public static BookItemDOT parse(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String title = rs.getString("title");
        long bookId = rs.getLong("bookId");
        Date publishedDate = rs.getDate("publishDate");
        String format = rs.getString("format");
        String publisher = rs.getString("publisher");
        int numberOfPages = rs.getInt("numberOfPages");
        double price = rs.getDouble("price");
        int quantity = rs.getInt("quantity");
        Instant dateAdded = rs.getTimestamp("dateAdded").toInstant();
        Instant dateModified = rs.getTimestamp("dateModified").toInstant();
        boolean available= rs.getBoolean("available");
        boolean deleted= rs.getBoolean("deleted");
        return new BookItemDOT(id, title,bookId, publishedDate, format, publisher, numberOfPages, price, quantity, dateAdded, dateModified, available, deleted);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
