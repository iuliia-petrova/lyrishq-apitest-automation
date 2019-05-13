package com.aurea.lyrishq.restapi.test.factories;

import com.xo.restapi.automation.context.UserData;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import lombok.var;

@UtilityClass
public class LyrisUserContext {

    @Setter(AccessLevel.PRIVATE)
    @Getter
    private String token;
    @Setter(AccessLevel.PRIVATE)
    @Getter
    private String orgId;
    private UserData userData;
    private LyrisUserFactory userFactory;
    @Getter
    private LyrisUser user;

    public static void setUserData(UserData param) {
        userData = param;
    }

    public static void setFactory(LyrisUserFactory factory) {
        userFactory = factory;
    }

    public static void setContext(String username) {
        var authString = userData.get(username);
        var userObject = userFactory.getUser(username, authString);
        user = userObject;
        setToken(userObject.getToken());
        setOrgId(userObject.getOrgId());
    }
}
