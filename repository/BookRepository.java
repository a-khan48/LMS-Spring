package com.example.library.repository;

import com.example.library.model.Book;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}