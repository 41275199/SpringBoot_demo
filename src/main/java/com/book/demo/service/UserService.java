package com.book.demo.service;

import com.book.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void deleteById(int id);
    void add(User user);
    List<User> findById(int id);
}
