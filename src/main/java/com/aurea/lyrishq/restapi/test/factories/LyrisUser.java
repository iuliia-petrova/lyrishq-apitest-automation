package com.aurea.lyrishq.restapi.test.factories;

import com.xo.restapi.automation.types.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LyrisUser extends User {

    private int id;
    private String username;
    private String password;
    private String token;
    private String orgId;
    private Enum<?> role;
}
