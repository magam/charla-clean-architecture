package com.fravega.ecommerce.poker.infrastructure.inject

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Component

@Component
@DependsOn("BeansConfiguration")
class JaxRsInjector : ResourceConfig() {

    init {
        packages("com.fravega.ecommerce.poker.infrastructure.rest")
    }

}