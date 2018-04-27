package com.self.model;


import com.self.bean.Book;

import java.beans.PropertyEditorSupport;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class BookEditor extends PropertyEditorSupport {
    public void setAsText(String text) throws IllegalArgumentException {
        Book book = new Book();
        if(text != null){
            String[] items = text.split(":");
            book.setBookId(Integer.valueOf(items[0]));
            book.setName(items[1]);
        }
        setValue(book);
    }
}
