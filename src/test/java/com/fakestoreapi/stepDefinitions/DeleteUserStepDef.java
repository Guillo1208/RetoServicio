package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.Deleteresponse;
import com.fakestoreapi.tasks.DeleteUsertask;
import com.fakestoreapi.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.mockito.internal.matchers.Equals;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }
    @When("I consume the endpoint and I send id")
    public void iConsumeTheEndpointAndISendId() {
        user.attemptsTo(
                DeleteUsertask.on()
        );
    }
    @Then("I can validate the phone")
    public void iCanValidateThePhone() {
        Map<String, String> data = Data.extractTo().get(0);
        user.should(
                seeThat("The server response was",
                        res-> Deleteresponse.was().answeredBy(user).getPhone(),
                        equalTo(data.get("Telefono"))
                        )
        );
    }

}
