package com.aurea.lyrishq.restapi.test.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Credentials {

    private String username;
    private String password;
}
