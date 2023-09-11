package com.phonebook.restAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static final String TOKEN =
            "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoicmFtbW1tMTIzQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNjkwNDQxNzQ1LCJpYXQiOjE2ODk4NDE3NDV9.mfK2XX-Wz7ixV-vpkyV3C0vgyYo0jZSMSBtbLT_cdI0";

    @BeforeMethod
    public void  precondition() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }
}
