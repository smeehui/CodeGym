create table libdb.books
(
    id           bigint       not null
        primary key,
    isbn         varchar(20)  null,
    title        varchar(255) null,
    author       varchar(255) null,
    subject      varchar(50)  null,
    language     varchar(50)  null,
    dateAdded    datetime     null,
    dateModified datetime     null,
    available    bit          not null,
    deleted      bit          null,
    constraint books_pk
        unique (isbn)
);

