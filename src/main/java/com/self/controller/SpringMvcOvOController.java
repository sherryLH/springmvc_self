package com.self.controller;
/**
 * 一个url请求一个方法
 */

import com.self.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class SpringMvcOvOController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/listAllBook/{date}")
    public String listAllBook(@PathVariable Date date, String context){
        System.out.println("method ---- listAllBook"+date+";"+context);
        return "listAllBook";
    }

    @RequestMapping("/listBookName.do")
    public String listBookName(int id){
        System.out.println("method ---- listBookName param id :" + id);
        return "listBookName";
    }
}
