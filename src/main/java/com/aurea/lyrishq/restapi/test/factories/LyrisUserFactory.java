package com.aurea.lyrishq.restapi.test.factories;

import static com.aurea.lyrishq.restapi.test.data.UrlConsts.SESSIONS;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;

import com.aurea.lyrishq.restapi.test.models.Credentials;
import com.aurea.lyrishq.restapi.test.types.UserImpl;
import com.xo.restapi.automation.factories.UserFactory;
import lombok.SneakyThrows;
import lombok.var;

public class LyrisUserFactory implements UserFactory {

    private static final String TOKEN = "token";
    private static final String ORG_ID = "org.lhqOrgUid";

    @Override
    @SneakyThrows
    public <E extends Enum<?>> LyrisUser getUser(String username, String password) {
        var authRequest = given()
                .contentType(JSON).and()
                .body(credentialsPayload(username, password))
                .when().post(SESSIONS);
        var token = authRequest
                .then().assertThat()
                .statusCode(SC_CREATED)
                .extract().jsonPath().getString(TOKEN);

        var orgId = authRequest
                .then().assertThat()
                .statusCode(SC_CREATED)
                .extract().jsonPath().getString(ORG_ID);

        return new UserImpl(token, orgId);
    }

    private Credentials credentialsPayload(String username, String password) {
        return Credentials.builder()
                .username(username)
                .password(password)
                .build();
    }
}
