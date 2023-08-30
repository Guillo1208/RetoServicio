package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.ServerResponse;
import com.fakestoreapi.tasks.PostUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PostUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the endpoint and I send the user information email, username password firstname lastname")
    public void iConsumeTheEndpointAndISendTheUserInformationEmailUsernamePasswordFirstnameLastname() {
        user.attemptsTo(
                PostUserTask.on()
        );
    }

    @Then("I validate the response services")
    public void iValidateTheResponseServices() {

        user.should(
                seeThat(
                        "The response code was: ",
                        ServerResponse.was(),
                        equalTo(200)
                )
        );

    }

}
