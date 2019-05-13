package com.aurea.lyrishq.restapi.test.e2e.mailling;

import static com.aurea.lyrishq.restapi.test.utilities.CommonConsts.MESSAGE;
import static com.aurea.lyrishq.restapi.test.utilities.CommonConsts.RANDOM;
import static com.xo.restapi.automation.builders.GenerationUtils.generateEmail;
import static com.xo.restapi.automation.builders.GenerationUtils.generateName;
import static org.apache.http.HttpStatus.SC_OK;

import com.aurea.lyrishq.restapi.test.e2e.commonsteps.LoginStepdefs;
import com.aurea.lyrishq.restapi.test.factories.LyrisUserActionUtils;
import com.aurea.lyrishq.restapi.test.factories.LyrisUserFactory;
import com.aurea.lyrishq.restapi.test.utilities.MailingListUtils;
import com.xo.restapi.automation.context.UserContext;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class MailingListStepdefs {

    private final LoginStepdefs userLoginSteps;
    private Response createResponse;
    private String attributeId;

    public MailingListStepdefs(LoginStepdefs userLoginSteps) {
        this.userLoginSteps = userLoginSteps;
    }

    @Before
    public static void beforeScenario() {
        UserContext.setFactory(new LyrisUserFactory());
    }

    @And("USER adds a new Mailing List")
    public void userAddsNewMailingList() {
        LyrisUserActionUtils.perform(userLoginSteps.getUserData(), () -> {
            createResponse = MailingListUtils.createMailingList(
                    MailingListUtils.getMailingListBody(generateName(5, RANDOM), generateName(5, RANDOM),
                            generateEmail(5, RANDOM)));

            createResponse
                    .then().assertThat()
                    .statusCode(SC_OK);
        });
    }

    @And("USER adds a new Attribute")
    public void userAddsToMailingListNewAttributeOfTypeTEXT() {
        LyrisUserActionUtils.perform(userLoginSteps.getUserData(), () -> {
            createResponse = MailingListUtils.createAttribute(generateName(5, RANDOM));

            attributeId = createResponse
                    .then().assertThat()
                    .statusCode(SC_OK)
                    .extract().jsonPath().getString(MESSAGE);
        });
    }

    @When("USER edit Attribute name of type (.*)")
    public void userEditAttributeName(String attributeType) {
        LyrisUserActionUtils.perform(userLoginSteps.getUserData(), () -> {
            createResponse = MailingListUtils.editAttribute(
                    MailingListUtils.getAttributeBody(generateName(5, RANDOM), attributeType));
        });
    }

    @Then("Verify that Attribute was edited successfully")
    public void verifyThatAttributeWasEditedSuccessfully() {
        createResponse
                .then().assertThat()
                .statusCode(SC_OK);
    }
}
