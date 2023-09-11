package com.phonebook.restAssuredTests;

import com.phonebook.dto.AuthRequestDto;
import com.phonebook.dto.AuthResponseDto;
import com.phonebook.dto.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RALoginTests extends TestBase {


    @Test
    public void loginSuccessTest() {
        AuthRequestDto auth = AuthRequestDto.builder()
                .username("rammmm123@gmail.com")
                .password("rAmmmm123-$")
                .build();

        AuthResponseDto responseDto = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);

        System.out.println(responseDto.getToken());
    }

    @Test
    public void loginWithWrongFormatEmailTest() {

        AuthRequestDto auth = AuthRequestDto.builder()
                .username("rammmm123gmail.com")
                .password("rAmmmm123-$")
                .build();

        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);

        System.out.println(errorDto.getMessage());
        System.out.println(errorDto.getError());
    }
        @Test
    public void loginWithWrongFormatEmailTest2() {

        AuthRequestDto auth = AuthRequestDto.builder()
                .username("rammmm123gmail.com")
                .password("rAmmmm123-$")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("message",
                        containsString("Login or Password incorrect"))
                .assertThat().body("error", equalTo("Unauthorized"));
    }
}


//

//rammmm123@gmail.com
//rAmmmm123-$