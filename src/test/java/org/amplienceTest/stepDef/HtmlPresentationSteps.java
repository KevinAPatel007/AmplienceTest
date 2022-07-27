package org.amplienceTest.stepDef;


import com.google.gson.Gson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import jdk.nashorn.internal.parser.JSONParser;
import org.amplienceTest.driver.DriverManager;
import org.amplienceTest.pageObject.HtmlPresentationPage;

import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HtmlPresentationSteps extends DriverManager {
    HtmlPresentationPage htmlPresentationPage = new HtmlPresentationPage();
    DriverManager driverManager = new DriverManager();
    Gson gson = new Gson();


    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
        driverManager.goToUrl();
        driverManager.maxBrowser();
        Thread.sleep(3000);
    }

    @When("I amend the URl with \"([^\"]*)\"")
    public void iAmendTheURlWith(String userId) throws InterruptedException {
        String actualUrl = driverManager.getUrl();
        driver.get(actualUrl + "/" + userId);
        Thread.sleep(3000);
    }

    @Then("I should see with values of \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"")
    public void iShouldSeeWithValuesOf(String expectedName, String expectedLocation, String expectedPublicRepos, String expectedPublicGists, String expectedFollowers, String expectedFollowing) {
        String pageSource = htmlPresentationPage.getTextFromApiPageResult();
        assertThat(pageSource.contains(expectedName),is(true));
        assertThat(pageSource.contains(expectedLocation),is(true));
        assertThat(pageSource.contains(expectedPublicRepos),is(true));
        assertThat(pageSource.contains(expectedPublicGists),is(true));
        assertThat(pageSource.contains(expectedFollowers),is(true));
        assertThat(pageSource.contains(expectedFollowing),is(true));

    }
}
