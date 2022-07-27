package org.amplienceTest.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.amplienceTest.utils.ConfigFileReader;
import org.amplienceTest.utils.RestServices;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;

public class GetAPIDataSteps {
    public Response response;
    public RestServices services = new RestServices();
    ConfigFileReader configFileReader = new ConfigFileReader("API-Env.properties");

    @Given("I have base uri")
    public void iHaveBaseUri() {
        assertThat(configFileReader.getApiEnvironment(), is(endsWith("api.github.com/users")));
    }

    @When("I execute get request with userId \"([^\"]*)\"")
    public void iExecuteGetRequestWithUserId(String userId) {
        response = services.getService(userId);
        response.prettyPrint();
    }

    @Then("I should see status code as \"([^\"]*)\"")
    public void iShouldSeeStatusCodeAs(String expectedStatusCode) {
        response.then().statusCode(Integer.parseInt(expectedStatusCode));
    }

    @And("I see response with values of \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"")
    public void iSeeResponseWithValuesOf(String expectedName, String expectedId, String expectedLocation, String expectedPublicRepos, String expectedPublicGists, String expectedFollowers, String expectedFollowing) {
        String actualName = response.then().extract().path("name").toString();
        String actualId = response.then().extract().path("id").toString();
        String actualLocation = response.then().extract().path("location").toString();
        String actualPublicRepos = response.then().extract().path("public_repos").toString();
        String actualPublicGists = response.then().extract().path("public_gists").toString();
        String actualFollowers = response.then().extract().path("followers").toString();
        String actualFollowing = response.then().extract().path("following").toString();

        assertThat(actualName, equalTo(expectedName));
        assertThat(actualId, equalTo(expectedId));
        assertThat(actualLocation, equalTo(expectedLocation));
        assertThat(actualPublicRepos, equalTo(expectedPublicRepos));
        assertThat(actualPublicGists, equalTo(expectedPublicGists));
        assertThat(actualFollowers, equalTo(expectedFollowers));
        assertThat(actualFollowing, equalTo(expectedFollowing));

    }
}
