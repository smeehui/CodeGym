package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.Book;
import com.librarymanagement.services.IAbstractService;

import java.util.List;

public interface IBookDAO extends IAbstractService<Book,Long> {
    Book getByISBN(String isbn);

    boolean existByISBN(String isbn);


    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);
}
