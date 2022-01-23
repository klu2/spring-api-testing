package io.agilecoding.spring.apitesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@SpringBootApplication
class SpringApiTestingApplication

fun main(args: Array<String>) {
    runApplication<SpringApiTestingApplication>(*args)
}

interface HelloApi {
    @GetMapping("/hello-world")
    fun helloWorld(): Message

}

@RestController
class HelloController : HelloApi {

    override fun helloWorld(): Message {
        return Message(message = "Hello World")
    }

}

data class Message(val message: String, val dateTime: OffsetDateTime = OffsetDateTime.now())
