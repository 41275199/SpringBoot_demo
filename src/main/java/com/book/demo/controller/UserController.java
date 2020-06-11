package com.book.demo.controller;

import com.book.demo.entity.PageResult;
import com.book.demo.entity.User;
import com.book.demo.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void add(@RequestBody User user){
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

}
