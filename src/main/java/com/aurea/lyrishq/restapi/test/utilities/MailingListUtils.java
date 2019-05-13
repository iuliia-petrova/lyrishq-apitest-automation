package com.aurea.lyrishq.restapi.test.utilities;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import com.aurea.lyrishq.restapi.test.data.UrlConsts;
import com.aurea.lyrishq.restapi.test.factories.LyrisUserContext;
import com.aurea.lyrishq.restapi.test.models.Attribute;
import com.aurea.lyrishq.restapi.test.models.MailingList;
import com.aurea.lyrishq.restapi.test.types.AttributeType;
import com.xo.restapi.automation.builders.DefaultObjectMapper;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MailingListUtils {

    public static Response createMailingList(MailingList mailingList) {
        return given()
                .header(OAuthUtils.X_LHQ_TOKEN, LyrisUserContext.getToken())
                .contentType(JSON)
                .body(DefaultObjectMapper.writeJson(mailingList))
                .when().post(LyrisUserContext.getOrgId() + UrlConsts.LISTS);
    }

    public static MailingList getMailingListBody(String name, String senderName, String email) {
        return MailingList.builder()
                .mailingListName(name)
                .fromName(senderName)
                .fromEmail(email)
                .build();
    }

    public static Response createAttribute(String name) {
        return given()
                .header(OAuthUtils.X_LHQ_TOKEN, LyrisUserContext.getToken())
                .contentType(JSON)
                .body(DefaultObjectMapper.writeJson(
                        Attribute.builder().name(name).build()
                ))
                .when().post(LyrisUserContext.getOrgId() + UrlConsts.ATTRIBUTES);
    }

    public static Response editAttribute(Attribute attribute) {
        return given()
                .header(OAuthUtils.X_LHQ_TOKEN, LyrisUserContext.getToken())
                .contentType(JSON)
                .body(DefaultObjectMapper.writeJson(attribute))
                .when().post(LyrisUserContext.getOrgId() + UrlConsts.ATTRIBUTES);
    }

    public static Attribute getAttributeBody(String name, String type) {
        return Attribute.builder()
                .name(name)
                .state("ENABLED")
                .type(type)
                .build();
    }
}
