package com.benxinm.bookapp.mappers;

import com.benxinm.bookapp.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> getAllBook();
}
