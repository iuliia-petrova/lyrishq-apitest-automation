package com.aurea.lyrishq.restapi.test.configs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

    Role role;
    int id;
    String username;
    String password;
}
