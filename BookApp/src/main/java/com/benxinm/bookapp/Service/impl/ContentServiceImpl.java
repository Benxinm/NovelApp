package com.benxinm.bookapp.Service.impl;

import com.benxinm.bookapp.Service.ContentService;
import com.benxinm.bookapp.entity.Content;
import com.benxinm.bookapp.mappers.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentMapper contentMapper;
    @Override
    public Content getContentById(Integer id) {
        return contentMapper.getContentById(id);
    }
}
