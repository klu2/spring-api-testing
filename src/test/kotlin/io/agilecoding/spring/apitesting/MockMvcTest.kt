package io.agilecoding.spring.apitesting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class MockMvcTest(
    @Autowired private val mockMvc: MockMvc
) {

    @Test
    fun helloWorld() {
        val result = mockMvc.perform(get("/hello-world"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.message").value("Hello World"))
            .andReturn()

        assertEquals(MediaType.APPLICATION_JSON_VALUE, result.response.contentType)
    }
}