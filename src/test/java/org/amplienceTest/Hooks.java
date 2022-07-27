package org.amplienceTest;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import org.amplienceTest.driver.DriverManager;
import org.amplienceTest.utils.ConfigFileReader;

public class Hooks extends DriverManager {
    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp() throws IllegalAccessException {
        driverManager.runOnLocalBrowser();
//        driverManager.runInHeadlessBrowser();
    }

    @Before
    public static void setBaseURI() {
        ConfigFileReader configFileReader = new ConfigFileReader("API-Env.properties");
        RestAssured.baseURI = configFileReader.getApiEnvironment();
    }

    @After
    public void tearDown() {
        driverManager.closeBrowser();
    }

}
