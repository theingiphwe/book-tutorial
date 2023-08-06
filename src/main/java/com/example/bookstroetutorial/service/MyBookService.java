package com.example.bookstroetutorial.service;

import com.example.bookstroetutorial.dao.MyBookDao;
import com.example.bookstroetutorial.entity.MyBookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookDao myBookDao;

    public  void saveMyBooks(MyBookList bookList){
        myBookDao.save(bookList);
    }

    public List<MyBookList> getAllMyyBooks(){
       return myBookDao.findAll();
    }

    public void deleteById(int id){
        myBookDao.deleteById(id);
    }
}
