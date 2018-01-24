package com.fravega.ecommerce.poker.infrastructure.inject

import com.fravega.ecommerce.poker.domain.actions.CalculatePlayerOneVictories
import com.fravega.ecommerce.poker.domain.actions.CalculateWinner
import com.fravega.ecommerce.poker.domain.actions.GetCardsRank
import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.HandFactory
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.infrastructure.data.SQLHandRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager

@Configuration("BeansConfiguration")
internal open class Injector {

    @Bean
    open fun beanFactory(): HandFactory {
        return HandFactory()
    }

    @Bean
    open fun deck(): Deck {
        return Deck()
    }

    @Bean
    open fun handRepository(em: EntityManager, handFactory: HandFactory): HandRepository {
        return SQLHandRepository(em, handFactory)
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