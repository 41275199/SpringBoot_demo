package com.book.demo.controller;

import com.book.demo.entity.PageResult;
import com.book.demo.entity.User;
import com.book.demo.service.UserService;
import com.book.demo.utils.POIUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> list = userService.findAll();
        return list;
    }
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        userService.deleteById(id);
    }

    @RequestMapping("/add")
    public void add( User user){
        userService.add(user);
    }
    @RequestMapping("/findById/{id}")
    public List<User> findById(@PathVariable("id") int id){
        List<User>  list = userService.findById(id);
        return list;
    }
    @GetMapping("/search/{page}/{size}")
    public PageResult<User> findpage(@PathVariable("page") int page,@PathVariable("size") int size){
        Page<User> pageInfo = userService.findPage(page, size);
        PageResult pageResult =new PageResult(pageInfo.getTotal(),pageInfo.getResult());
        return pageResult;
    }
   @RequestMapping("/upload")
    public boolean upload(@RequestParam("excelFile")MultipartFile excelFile){
       try {
           List<String[]> list = POIUtils.readExcel(excelFile);
           for (String[] strings : list) {
               String username = strings[0];
               String password = strings[1];
               User NewUser = new User();
               NewUser.setId(null);
               NewUser.setUsername(username);
               NewUser.setPassword(password);
               userService.add(NewUser);

           }

       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
       return true;
   }
}
