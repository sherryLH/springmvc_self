package com.self.controller;
/**
 * 一个url，根据参数（params 的值）判断所走的方法
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Book.do")
public class SpringMvcOneVMoreController {

    @RequestMapping(params="method=listAllBook")
    public String listAllBook(){
        System.out.println("OneVMore method -- listAllBook");
        return "One V More :listAllBook";
    }

    @RequestMapping(params="method=listBookName")
    public String listBookName(int id){
        System.out.println("One V More method -- listBookName");
        return "One v More :listBookName";
    }
}
