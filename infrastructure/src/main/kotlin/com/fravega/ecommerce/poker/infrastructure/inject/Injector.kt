package com.fravega.ecommerce.poker.infrastructure.inject

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.actions.CalculatePlayer1Wins
import com.fravega.ecommerce.poker.domain.model.HandFactory
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.infrastructure.PokerConfiguration
import com.fravega.ecommerce.poker.infrastructure.data.FileHandRepository
import com.fravega.ecommerce.poker.infrastructure.rest.Player1WinsResource

internal class Injector(private val configuration: PokerConfiguration) {

    val handFactory: HandFactory = HandFactory()

    val deck: Deck = Deck()

    val handRepository: HandRepository by lazy {
        FileHandRepository(configuration.dataSource.path, handFactory)
    }

    val calculatePlayer1Wins: CalculatePlayer1Wins by lazy {
        CalculatePlayer1Wins(handRepository, deck)
    }

    val player1WinsResource: Player1WinsResource by lazy {
        Player1WinsResource(calculatePlayer1Wins)
    }

}