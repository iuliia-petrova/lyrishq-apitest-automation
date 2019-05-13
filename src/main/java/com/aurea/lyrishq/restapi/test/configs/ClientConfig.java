package com.aurea.lyrishq.restapi.test.configs;

public class ClientConfig {
    private UserInfo[] userInfo;

    public UserInfo[] getUserInfo() {
        if (userInfo == null) {
            return new UserInfo[0];
        } else {
            return userInfo.clone();
        }
    }

    public void setUserInfo(UserInfo[] userInfo) {
        if (userInfo == null) {
            this.userInfo = new UserInfo[0];
        } else {
            this.userInfo = userInfo.clone();
        }
    }
}
