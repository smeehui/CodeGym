create table libdb.users
(
    id           int auto_increment
        primary key,
    fullName     varchar(50)  not null,
    address      varchar(255) null,
    phone        varchar(50)  null,
    email        varchar(30)  null,
    username     varchar(50)  null,
    password     varchar(20)  null,
    role         int          null,
    dateAdded    datetime     null,
    dateModified datetime     null,
    deleted      bit          null,
    constraint foreign_key_name
        foreign key (role) references libdb.roles (id)
);

