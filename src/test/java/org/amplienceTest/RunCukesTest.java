package org.amplienceTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.amplienceTest.utils.ConfigFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        dryRun = false,
        tags="@TestApi",
        plugin = "json:target/cucumber-report/cucumber.json")

public class RunCukesTest {

}
