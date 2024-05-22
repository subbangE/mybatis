package com.mysite.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 모든 변수를 다넣어서 User 생성자를 만들어줌
public class User {

    private String id;
    private String name;
    private String phone;
    private String address;


}
