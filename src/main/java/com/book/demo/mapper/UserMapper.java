package com.book.demo.mapper;

import com.book.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> findAll();
//    @Delete("delete from tb_user where id = #{id} ")
    void deleteById(int id);
    void add(User user);
    List<User> findById(int id);
}