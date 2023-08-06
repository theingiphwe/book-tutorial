package com.example.bookstroetutorial.service;

import com.example.bookstroetutorial.dao.BookDao;
import com.example.bookstroetutorial.entity.Book;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void save(Book book){
        bookDao.save(book);
    }
    public List<Book> getAllBook(){
        return bookDao.findAll();
    }

    public Book getBookById(int id){
        return bookDao.findById(id).get();
    }

    public void deleteById(int id){
        bookDao.deleteById(id);
    }
}
