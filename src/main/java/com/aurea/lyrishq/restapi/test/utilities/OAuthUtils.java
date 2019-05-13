package com.aurea.lyrishq.restapi.test.utilities;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

/**
 * This is a typical utility class containing common methods.
 * It contains examples of using builders for POJOs and request methods.
 * To be removed or replaced.
 */

@UtilityClass
public class OAuthUtils {

    public static final String X_LHQ_TOKEN = "X-LHQ-TOKEN";

    public static RequestSpecification getOAuthRequestSpecification(String basic) {
        return given()
                .contentType(JSON).and()
                .header(AUTHORIZATION, basic);
    }
}
