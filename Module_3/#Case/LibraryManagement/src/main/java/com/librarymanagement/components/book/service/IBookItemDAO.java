package com.librarymanagement.components.book.service;

import com.librarymanagement.components.book.model.BookItem;
import com.librarymanagement.services.IAbstractService;

public interface IBookItemDAO extends IAbstractService<BookItem,Long> {
    boolean updateQuantity();
}
