package com.fravega.ecommerce.poker.infrastructure.inject

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.actions.CalculatePlayer1Victories
import com.fravega.ecommerce.poker.domain.actions.CalculateWinner
import com.fravega.ecommerce.poker.domain.model.HandFactory
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.infrastructure.PokerConfiguration
import com.fravega.ecommerce.poker.infrastructure.data.FileHandRepository
import com.fravega.ecommerce.poker.infrastructure.rest.Player1VictoriesResource
import com.fravega.ecommerce.poker.infrastructure.rest.WinnerResource

internal class Injector(private val configuration: PokerConfiguration) {

    private val handFactory: HandFactory = HandFactory()

    private val deck: Deck = Deck()

    private val handRepository: HandRepository by lazy {
        FileHandRepository(configuration.dataSource.path, handFactory)
    }

    private val calculatePlayer1Victories: CalculatePlayer1Victories by lazy {
        CalculatePlayer1Victories(handRepository, deck)
    }

    private val calculateWinner: CalculateWinner by lazy {
        CalculateWinner(handRepository, deck)
    }

    val player1VictoriesResource: Player1VictoriesResource by lazy {
        Player1VictoriesResource(calculatePlayer1Victories)
    }

    val winnerResource: WinnerResource by lazy {
        WinnerResource(calculateWinner)
    }

}