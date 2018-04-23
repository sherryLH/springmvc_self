package com.self.controller;
/**
 * 一个url，根据参数（params 的值）判断所走的方法
 */

import com.self.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Book.do")
public class SpringMvcOneVMoreController {

    @RequestMapping(params="method=listAllBook", method = RequestMethod.GET)
    public String listAllBook(){
        System.out.println("OneVMore method -- listAllBook");
        return "listAllBook";
    }

    //http://localhost:8080/springmvc/Book.do?method=listBookName&id=3&bookId=4&name=名字
    @RequestMapping(params="method=listBookName")
    public String listBookName(int id, Book book){
        System.out.println("One V More method -- listBookName param id:"+id +";book:"+book.getBookId()+";"+book.getName());
        return "listBookName";
    }
}
