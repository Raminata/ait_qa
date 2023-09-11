package com.phonebook.restAssuredTests;


import com.phonebook.dto.OrdersAcceptedDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OrdersAcceptedTest extends TestBase {

    @Test
    public void acceptNewOrderTest() {

        OrdersAcceptedDto dto = OrdersAcceptedDto.builder()
                .confectionerId("1")
                .build();

        String state = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "token")
                .body(dto)
                .when()
                .put("orders/3")
                .then()
                .assertThat().statusCode(200)
                .extract().path("state");

        System.out.println(state);
    }
}
