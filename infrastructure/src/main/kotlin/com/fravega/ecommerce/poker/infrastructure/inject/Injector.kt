package com.fravega.ecommerce.poker.infrastructure.inject

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.actions.CalculatePlayerOneVictories
import com.fravega.ecommerce.poker.domain.actions.CalculateWinner
import com.fravega.ecommerce.poker.domain.actions.GetCardsRank
import com.fravega.ecommerce.poker.domain.model.HandFactory
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.infrastructure.data.FileHandRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("BeansConfiguration")
internal open class Injector {

    @Value("\${dataSource.path}")
    private lateinit var filePath: String

    @Bean
    open fun beanFactory(): HandFactory {
        return HandFactory()
    }

    @Bean
    open fun deck(): Deck {
        return Deck()
    }

    @Bean
    open fun handRepository(handFactory: HandFactory): HandRepository {
        return FileHandRepository(filePath, handFactory)
    }

    @Bean
    open fun calculatePlayerOneVictories(handRepository: HandRepository, deck: Deck): CalculatePlayerOneVictories {
        return CalculatePlayerOneVictories(handRepository, deck)
    }

    @Bean
    open fun calculateWinner(handRepository: HandRepository, deck: Deck): CalculateWinner {
        return CalculateWinner(handRepository, deck)
    }

    @Bean
    open fun getCardsRank(handRepository: HandRepository): GetCardsRank {
        return GetCardsRank(handRepository)
    }
}