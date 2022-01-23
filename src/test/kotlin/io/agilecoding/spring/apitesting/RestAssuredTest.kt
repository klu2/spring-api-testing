package io.agilecoding.spring.apitesting

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestAssuredTest(
    @LocalServerPort private val localServerPort: Int
) {

    @BeforeEach
    fun setup() {
        RestAssured.port = localServerPort
    }

    @Test
    fun helloWorld() {
        given().get("/hello-world").then()
            .statusCode(200)
            .assertThat()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body("message", equalTo("Hello World"))
    }

    @Test
    fun helloWorldMapping() {
        assertThat(given().get("/hello-world").`as`(Message::class.java).message)
            .isEqualTo("Hello World")
    }

}