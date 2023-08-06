package com.example.bookstroetutorial.controller;

import com.example.bookstroetutorial.entity.Book;
import com.example.bookstroetutorial.entity.MyBookList;
import com.example.bookstroetutorial.service.BookService;
import com.example.bookstroetutorial.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookService myBookService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_book")
    public ModelAndView bookList(Model model){
        return new ModelAndView("bookList","book",bookService.getAllBook());
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_book";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list=myBookService.getAllMyyBooks();
        model.addAttribute("books",list);
        return "myBooks";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable ("id") int id){
        Book book=bookService.getBookById(id);
        MyBookList mb=new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }


    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable ("id") int id,Model model){
        Book b=bookService.getBookById(id);
       model.addAttribute("book",b);

        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_book";
    }

}
