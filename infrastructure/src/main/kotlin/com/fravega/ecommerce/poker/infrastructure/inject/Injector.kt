package com.fravega.ecommerce.poker.infrastructure.inject

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.actions.CalculatePlayerOneVictories
import com.fravega.ecommerce.poker.domain.actions.CalculateWinner
import com.fravega.ecommerce.poker.domain.actions.GetCardsRank
import com.fravega.ecommerce.poker.domain.model.HandFactory
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.infrastructure.PokerConfiguration
import com.fravega.ecommerce.poker.infrastructure.data.FileHandRepository
import com.fravega.ecommerce.poker.infrastructure.rest.CardsRankResource
import com.fravega.ecommerce.poker.infrastructure.rest.PlayerOneVictoriesResource
import com.fravega.ecommerce.poker.infrastructure.rest.WinnerResource

internal class Injector(private val configuration: PokerConfiguration) {

    private val handFactory: HandFactory = HandFactory()

    private val deck: Deck = Deck()

    private val handRepository: HandRepository by lazy {
        FileHandRepository(configuration.dataSource.path, handFactory)
    }

    private val calculatePlayerOneVictories: CalculatePlayerOneVictories by lazy {
        CalculatePlayerOneVictories(handRepository, deck)
    }

    private val calculateWinner: CalculateWinner by lazy {
        CalculateWinner(handRepository, deck)
    }

    private val getCardsRank: GetCardsRank by lazy {
        GetCardsRank(handRepository)
    }

    val playerOneVictoriesResource: PlayerOneVictoriesResource by lazy {
        PlayerOneVictoriesResource(calculatePlayerOneVictories)
    }

    val winnerResource: WinnerResource by lazy {
        WinnerResource(calculateWinner)
    }

    val cardsRankResource: CardsRankResource by lazy {
        CardsRankResource(getCardsRank)
    }

}