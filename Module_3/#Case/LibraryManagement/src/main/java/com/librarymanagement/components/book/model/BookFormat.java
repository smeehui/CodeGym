package com.librarymanagement.components.book.model;

public enum BookFormat {
    PAPERBACK(1),
    HARDCOVER(2),
    NEWSPAPER(5),
    MAGAZINE(4),
    EBOOK(3);

    private final int value;
    
     BookFormat(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static BookFormat parserBookFormat(int value) {
        BookFormat[] values = values();
        for (BookFormat bookFormat : values) {
            if (bookFormat.value == (value))
                return bookFormat;
        }

        throw new IllegalArgumentException("Invalid BookFormat value : " + value);

    }
}
