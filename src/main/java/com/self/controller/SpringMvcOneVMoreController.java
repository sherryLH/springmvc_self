package com.self.controller;
/**
 * 一个url，根据参数（params 的值）判断所走的方法
 */

import com.self.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.security.acl.Owner;
import java.util.Iterator;

@Controller
@RequestMapping("/Book.do")
@SessionAttributes("book0")//将放到modelMap中key=book的对象作为session对象
public class SpringMvcOneVMoreController {

    @RequestMapping(params="method=listAllBook", method = RequestMethod.GET)
    public String listAllBook(){
        System.out.println("OneVMore method -- listAllBook");
        return "listAllBook";//被解析为逻辑视图的名称
    }

    //http://localhost:8080/springmvc/Book.do?method=listBookName&id=3&bookId=4&name=名字
    //@RequestParam("ID") 对入参id进行注解，并将ID替换id绑定在请求参数上
    @RequestMapping(params="method=listBookName")
    public String listBookName(@RequestParam("ID") int id, Book book){
        System.out.println("One V More method -- listBookName param id:"+id +";book:"+book.getBookId()+";"+book.getName());
        return "listBookName";
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

    public String processSubmit(@ModelAttribute Owner owner, BindingResult result, SessionStatus status){
        new Owner().
    }
}
