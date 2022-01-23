package io.agilecoding.spring.apitesting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringBootControllerTest(
    @Autowired private val controller: HelloController
) {

    @Test
    fun hwlloWorld() {
        assertEquals("Hello World", controller.helloWorld().message)
    }

}
