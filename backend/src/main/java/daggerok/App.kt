package daggerok

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.router

@Configuration
class WebFlux {

  @Bean
  fun routes() = router {
    resources("/**", ClassPathResource("META-INF/resources/public/"))
    "/".nest {
      GET("/**") {
        ok().contentType(TEXT_HTML).render("index")
        // was ugly workaround...
        ////permanentRedirect(URI.create("/index.html")).build()
      }
    }
  }
}

@SpringBootApplication
class App

fun main(args: Array<String>) {
  runApplication<App>(*args)
}
