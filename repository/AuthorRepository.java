package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}