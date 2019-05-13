package com.aurea.lyrishq.restapi.test.e2e.commonsteps;

import com.aurea.lyrishq.restapi.test.configs.Role;
import com.aurea.lyrishq.restapi.test.configs.UserDataReader;
import com.aurea.lyrishq.restapi.test.configs.UserInfo;
import com.aurea.lyrishq.restapi.test.factories.LyrisUserActionUtils;
import com.aurea.lyrishq.restapi.test.factories.LyrisUserContext;
import com.xo.restapi.automation.context.UserData;
import cucumber.api.java.en.Given;
import lombok.Getter;

public class LoginStepdefs {

    @Getter
    private UserData userData = new UserData();

    @Given("^(.*) logged into the system$")
    public void loggedIntoTheSystem(String userRole) {
        UserInfo roleCredentials = UserDataReader.getInstance().getRole(Role.valueOf(userRole));
        userData.addUser(roleCredentials.getUsername(), roleCredentials.getPassword());
        LyrisUserContext.setUserData(userData);
        LyrisUserActionUtils.perform(roleCredentials.getUsername(), LyrisUserContext::getToken);
    }
}
