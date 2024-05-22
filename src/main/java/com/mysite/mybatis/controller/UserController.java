package com.mysite.mybatis.controller;

import com.mysite.mybatis.mapper.UserMapper;
import com.mysite.mybatis.model.User;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController 는 화면없이 바로 객체나 문자열을 제이슨으로 리턴 => 공공데이터가 줄때 사용
@RestController // 화면이 없는 컨트롤러
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        User user = userMapper.getUser(id);
        return user;
    }

    // 모든 유저 리스트를 리턴
    @GetMapping
    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }

    @PostMapping
    public void createUser(@RequestParam("id") String id,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone,
                           @RequestParam("address") String address) {
        userMapper.insertUser(id, name, phone, address);
    }

    // 유저 업데이트 PUT 메서드
    @PutMapping("/{id}")
    public void editUser( @PathVariable("id") String id,
                          @RequestParam("name") String name,
                          @RequestParam("phone") String phone,
                          @RequestParam("address") String address) {
        userMapper.updateUser(id, name, phone, address);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userMapper.deleteUser(id);
    }
}
