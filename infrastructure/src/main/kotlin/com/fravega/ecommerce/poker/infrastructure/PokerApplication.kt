package com.fravega.ecommerce.poker.infrastructure

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer


@SpringBootApplication
open class PokerApplication : SpringBootServletInitializer() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(PokerApplication::class.java, *args)
        }
    }
}

