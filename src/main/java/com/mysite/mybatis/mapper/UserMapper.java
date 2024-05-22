package com.mysite.mybatis.mapper;

import com.mysite.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Mybatis 는 Repository(JPA 사용시) 대신에 Mapper 를 사용하여 만듬
@Mapper
public interface UserMapper {

    // XML 대신에 @sql(SELECT, UPDATE, DELETE, INSERT) 로 바로 작성 가능
    @Select("select * from user where id=#{id}")
    User getUser(String id);

    @Select("select * from user")
    List<User> getUserList();

    @Insert("insert into user values(#{id}, #{name}, #{phone}, #{address})")
    int insertUser(String id, String name, String phone, String address);

    // 유저 업데이트
    @Update("update user set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
    int updateUser(String id, String name, String phone, String address);

    @Delete("delete from user where id=#{id}")
    int deleteUser(String id);
}