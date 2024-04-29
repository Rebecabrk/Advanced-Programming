-- creating a table for books
set serveroutput on;

 CREATE TABLE books (
     bookID integer,
     title varchar(1000),
     authors varchar(1000),
     average_rating numeric(2,2),
     isbn integer,
     isbn13 integer,
     language_code varchar(10),
     num_pages integer,
     ratings_count integer,
     text_reviews_count integer,
     publication_date varchar(100),
     publisher varchar(1000)
);
/

 CREATE TABLE books (
     bookID varchar(1000),
     title varchar(1000),
     authors varchar(1000),
     average_rating varchar(1000),
     isbn varchar(1000),
     isbn13 varchar(1000),
     language_code varchar(1000),
     num_pages varchar(1000),
     ratings_count varchar(1000),
     text_reviews_count varchar(1000),
     publication_date varchar(1000),
     publisher varchar(1000)
);

CREATE TABLE authors(
    id integer,
    name varchar(50),
    book_id integer
);

CREATE TABLE genre(
    id integer,
    type varchar(20)
);

