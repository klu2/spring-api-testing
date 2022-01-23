package io.agilecoding.spring.apitesting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestRestTemplateTest(
    @LocalServerPort private val localServerPort: Int,
    @Autowired private val restTemplate: TestRestTemplate
) {

    @Test
    fun helloWorld() {
        val url = "http://localhost:$localServerPort/hello-world"
        assertThat(restTemplate.getForObject(url, Message::class.java).message)
            .isEqualTo("Hello World")
    }
}