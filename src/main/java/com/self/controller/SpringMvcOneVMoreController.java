package com.self.controller;
/**
 * 一个url，根据参数（params 的值）判断所走的方法
 */

import com.self.bean.Book;
import com.self.web.MyBindingInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/Book.do")
@SessionAttributes("book0")//将放到modelMap中key=book的对象作为session对象
public class SpringMvcOneVMoreController {

    @RequestMapping(params="method=listAllBook", method = RequestMethod.GET)
//    public String listAllBook(){
    public ModelAndView listAllBook(){
        System.out.println("OneVMore method -- listAllBook");
//        return "listAllBook";//被解析为逻辑视图的名称
        Book book = new Book();
        book.setBookId(1);
        book.setName("验证ModelAndView传对象");
        Book book2 = new Book();
        book2.setBookId(2);
        book2.setName("验证ModelAndView传对象2");
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(book2);
        ModelAndView modelAndView = new ModelAndView("listAllBook");
        modelAndView.addObject("message","参数message");
        modelAndView.addObject(book);
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    //http://localhost:8080/springmvc/Book.do?method=listBookName&id=3&bookId=4&name=名字
    //@RequestParam("ID") 对入参id进行注解，并将ID替换id绑定在请求参数上
    @RequestMapping(params="method=listBookName")
//    public String listBookName(@RequestParam("ID") int id, Book book){
    public ModelAndView listBookName(@RequestParam("ID") int id, Book book){
        System.out.println("One V More method -- listBookName param id:"+id +";book:"+book.getBookId()+";"+book.getName());
//        return "listBookName";
        String message = "返回给页面 请求ID："+id;
        return new ModelAndView("listBookName","message",message);
    }

    //org.springframework.ui.ModelMap 类，作为通用的模型数据承载对象
    @RequestMapping(params = "method=listBookId")
    public String listBookId(@RequestParam("Id") Integer id, Book book, ModelMap modelMap, HttpSession session){//modelMap 包含了本次请求的对象
        System.out.println("springmvcOvM listBookId  param id="+id+";book.getBookId()="+book.getBookId()+";book.getName()="+book.getName());
        if (modelMap != null && modelMap.size() > 0){
            int size = 1;
            for (Iterator<String> keys = modelMap.keySet().iterator() ; keys.hasNext();){
                String key = keys.next();
                System.out.println("modelMap.get("+key+")="+modelMap.get(key));
                Book book1 = (Book)modelMap.get(key);
                System.out.println("key="+key+";value=["+book1.getBookId()+";"+book1.getName()+"]");
                if(size == modelMap.size()-1)
                    break;
                size ++;
            }
        }
        /*HttpSession session = getClass().*/
        System.out.println(session.getId()+";"+session.getCreationTime()+";"+session.isNew());
        //将book对象以bookId为可以放到model中
        if(modelMap.get("book0") != null)
            modelMap.remove("book0");
        modelMap.addAttribute("book0",book);
        return "listBookId";
    }

    @RequestMapping(params = "method=book")
    public String book(@ModelAttribute("book0") Book book, HttpSession session){//获取session级别存储在modelMap中的book对象绑定到对应的Book类对象中
        System.out.println(session.getId()+";"+session.getCreationTime()+";"+session.isNew());
        System.out.println("book=["+book.getBookId()+";"+book.getName()+"]");
        return "book";
    }

    @RequestMapping(params="method=process")
    public String processSubmit(@ModelAttribute("book0")Book book, BindingResult result, SessionStatus status, ModelMap modelMap){
        System.out.println(modelMap.size()+";book0["+book.getName()+";"+book.getBookId()+"]");
        status.setComplete();//将本Controller中所有存放在session级别的模型属性数据从session中清空
        System.out.println(modelMap.size()+";"+status.isComplete());
        return "process";
    }

    //使用自定义注释
    @RequestMapping(params = "method=selfSys")
    public String selfSys(@RequestParam("book")Book book){
        System.out.println("book=["+book.getBookId()+":"+book.getName()+"]");
        return "selfSys";
    }
}
