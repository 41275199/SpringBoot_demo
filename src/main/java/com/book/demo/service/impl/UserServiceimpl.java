package com.book.demo.service.impl;

import com.book.demo.entity.User;
import com.book.demo.mapper.UserMapper;
import com.book.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<User> findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
