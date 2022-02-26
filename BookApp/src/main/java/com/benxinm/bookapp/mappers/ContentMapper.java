package com.benxinm.bookapp.mappers;

import com.benxinm.bookapp.entity.Content;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentMapper {
    Content getContentById(Integer id);
}
