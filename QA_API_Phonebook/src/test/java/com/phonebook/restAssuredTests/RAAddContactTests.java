package com.phonebook.restAssuredTests;

import com.phonebook.dto.ContactDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RAAddContactTests extends TestBase {

    @Test
    public void addNewContactSuccessTest() {

        ContactDto contactDto = ContactDto.builder()
                .name("John")
                .lastName("Wilson")
                .email("mark123@gmail.com")
                .phone("1234567890")
                .address("Berlin")
                .description("goal")
                .build();

        String message = given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN)
                .body(contactDto)
                .when()
                .post("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().path("message");

        System.out.println(message);
    }
}

//Contact was added! ID: 77b0ce08-db6f-49c7-a06a-b7665653903a
