package com.self.controller;
/**
 * 一个url请求一个方法
 */

import com.self.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMvcOvOController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/listAllBook.do")
    public String listAllBook(){
        System.out.println("method ---- listAllBook");
        return "listAllBook";
    }

    @RequestMapping("/listBookName.do")
    public String listBookName(int id){
        System.out.println("method ---- listBookName param id :" + id);
        return "listBookName";
    }
}
