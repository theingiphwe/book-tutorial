package com.example.bookstroetutorial.dao;

import com.example.bookstroetutorial.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {
}
