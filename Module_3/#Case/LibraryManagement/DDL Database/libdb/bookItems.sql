create table libdb.bookItems
(
    id            bigint      not null
        primary key,
    publishDate   date        null,
    format        int         null,
    publisher     varchar(50) null,
    numberOfPages int         null,
    price         double      null,
    bookId        bigint      not null,
    dateAdded     timestamp   null,
    dateModified  timestamp   null,
    available     bit         null,
    deleted       int         null,
    constraint bookItem_pk
        unique (bookId),
    constraint bookItem_books_id_fk
        foreign key (bookId) references libdb.books (id),
    constraint bookItem_format__fk
        foreign key (format) references libdb.bookItemFormat (id)
);

