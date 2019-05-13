package com.aurea.lyrishq.restapi.test.e2e.commonsteps;

import static com.xo.restapi.automation.configs.RestAssuredConfigUtils.setBaseUri;
import static com.aurea.lyrishq.restapi.test.configs.UserDataReader.DEFAULT;

import com.aurea.lyrishq.restapi.test.factories.LyrisUserContext;
import com.aurea.lyrishq.restapi.test.configs.UserDataReader;
import com.aurea.lyrishq.restapi.test.factories.LyrisUserFactory;
import cucumber.api.java.Before;

@SuppressWarnings("PMD.ClassNamingConventions")
public class Hooks {

    @Before
    public void beforeScenario() {
        UserDataReader.init(DEFAULT);
        LyrisUserContext.setFactory(new LyrisUserFactory());
        setBaseUri(DEFAULT);
    }
}
