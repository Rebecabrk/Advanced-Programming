-- creating a table for books
set serveroutput on;

CREATE TABLE books (
    id integer,
    genre_id integer,
    author_id integer,
    title varchar(50),
    language varchar(10),
    publication_date date,
    number_of_pages integer
);
/

CREATE TABLE authors(
    id integer,
    name varchar(50),
    book_id integer
);

CREATE TABLE genre(
    id integer,
    type varchar(20)
);

