package com.aurea.lyrishq.restapi.test.types;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Credential {

    public static final String ID_PLACEHOLDER = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    private transient long id;
    private transient String username;
    private transient String password;

    public Credential(final Map<String, String> items) {
        id = Integer.parseInt(items.get(ID_PLACEHOLDER));
        username = items.get(USERNAME);
        password = items.get(PASSWORD);
    }
}
