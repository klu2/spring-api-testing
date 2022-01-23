package io.agilecoding.spring.apitesting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.cloud.openfeign.FeignClientBuilder
import org.springframework.context.ApplicationContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OpenFeignIntegrationTest(
    @LocalServerPort private val localServerPort: Int,
    @Autowired private val applicationContext: ApplicationContext
) {

    private val helloApi =
        FeignTestClientFactory.createClientApi(HelloApi::class.java, localServerPort, applicationContext)

    @Test
    fun helloWorld() {
        assertThat(helloApi.helloWorld().message).isEqualTo("Hello World")
    }
}

object FeignTestClientFactory {
    fun <T> createClientApi(apiClass: Class<T>, port: Int, clientContext: ApplicationContext): T {
        return FeignClientBuilder(clientContext)
            .forType(apiClass, apiClass.canonicalName)
            .url("http://localhost:$port")
            .build()
    }
}