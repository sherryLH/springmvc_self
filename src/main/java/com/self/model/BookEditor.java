package com.self.model;


import com.self.bean.Book;

import javax.persistence.criteria.CriteriaBuilder;
import java.beans.PropertyEditorSupport;

public class BookEditor extends PropertyEditorSupport {
    public void setAsText(String text){
        Book book = new Book();
        if(text != null){
            String[] items = text.split(":");
            book.setBookId(Integer.valueOf(items[0]));
            book.setName(items[1]);
        }
        setValue(book);
    }
}
