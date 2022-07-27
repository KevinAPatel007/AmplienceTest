package org.amplienceTest.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestServices {

    ConfigFileReader configFileReader = new ConfigFileReader("API-Env.properties");
    String baseUri = configFileReader.getApiEnvironment();

    public Response getService(String userId) {
        return given().contentType(ContentType.JSON)
                .baseUri(baseUri)
                .when()
                .get("/"+userId);
    }

    public Response getByCoordinatesService(String latValue, String lonValue) {
        return given().contentType(ContentType.JSON)
                .queryParam("lat", latValue)
                .queryParam("lon", lonValue)
                .when()
                .get("/");

    }

}
