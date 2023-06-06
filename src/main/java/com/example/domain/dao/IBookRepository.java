package com.example.domain.dao;

import com.example.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book as b INNER JOIN SCard as s ON b.id = s.book.id UNION SELECT f FROM Book as f INNER JOIN TCard as t ON f.id = t.book.id")
    List<Book> BooksInUse();

    @Query("SELECT b FROM Book as b WHERE b.quantity>0")
    List<Book> BooksInStock();

    @Query("SELECT b FROM Book as b INNER JOIN SCard as s ON b.id = s.book.id and s.dateOut<=:dateTime UNION SELECT f FROM Book as f INNER JOIN TCard as t ON f.id = t.book.id and t.dateOut<=:dateTime")
    List<Book> notReturnedBooks(@Param("dateTime") Date dateTime);

    List<Book> findByNameContainingIgnoreCase(String value);
}

