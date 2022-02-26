package com.benxinm.bookapp.controller;

import com.alibaba.fastjson.JSON;
import com.benxinm.bookapp.Service.BookService;
import com.benxinm.bookapp.Service.ContentService;
import com.benxinm.bookapp.Service.UserService;
import com.benxinm.bookapp.StatusCode;
import com.benxinm.bookapp.entity.Book;
import com.benxinm.bookapp.entity.Content;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class IndexController {
    @Autowired
    UserService userService;

    //登录模块
    @GetMapping("/login")
    public Map<Integer,String> login(@RequestParam("ac") String account, @RequestParam("psd") String psd){
        System.out.println("登录被调用");
        HashMap<Integer, String> map = new HashMap<>();
        if (userService.getPsd(account, psd)){
            map.put(StatusCode.RESULT_OK,JSON.toJSONString(userService.getByAccount(account)));
        }else {
            map.put(StatusCode.RESULT_FAIL,"");
        }
        return map;
    }
    //注册模块
    @GetMapping("/register")
    public int register(@RequestParam("ac") String account,@RequestParam("psd") String psd){
        System.out.println("被调用");
        if(userService.checkExist(account)){
            return userService.insertUser(account,psd)>0? StatusCode.RESULT_OK:StatusCode.RESULT_FAIL;
        } else {
            return StatusCode.RESULT_FAIL;
        }
    }

    @Autowired
    BookService bookService;

    //获取全部书籍信息
    @GetMapping("/get/book")
    public String getAllBook(){
        return JSON.toJSONString(bookService.getAllBook());
    }

    @Autowired
    ContentService contentService;
    //获取小说内容
    @GetMapping("/get/content")
    public String getContentById(@RequestParam("id") Integer id){
        return JSON.toJSONString(contentService.getContentById(id));
    }
}
