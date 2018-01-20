package com.fravega.ecommerce.poker.infrastructure

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class PokerApplication : Application<PokerConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PokerApplication().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<PokerConfiguration>) {
        super.initialize(bootstrap)
        with(bootstrap.objectMapper) {
            findAndRegisterModules()
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
        }
    }

    override fun run(configuration: PokerConfiguration, environment: Environment) {

    }
}

data class PokerConfiguration(@JsonProperty("dataSource") val dataSource: DataSourceConfiguration) : Configuration()

data class DataSourceConfiguration(val path: String)

