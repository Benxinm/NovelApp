package com.benxinm.bookapp.Service.impl;

import com.benxinm.bookapp.Service.BookService;
import com.benxinm.bookapp.entity.Book;
import com.benxinm.bookapp.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }
}
