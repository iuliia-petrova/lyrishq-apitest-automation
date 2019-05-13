package com.aurea.lyrishq.restapi.test.types;

import com.aurea.lyrishq.restapi.test.factories.LyrisUser;


public class UserImpl extends LyrisUser {

    public UserImpl(String token, String orgId) {

        setToken(token);
        setOrgId(orgId);
    }
}
