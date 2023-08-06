package com.example.bookstroetutorial.dao;

import com.example.bookstroetutorial.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookDao extends JpaRepository<MyBookList,Integer> {
}
