package com.fravega.ecommerce.poker.domain.actions

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.Player
import com.fravega.ecommerce.poker.domain.model.HandRepository

class CalculatePlayer1Wins(private val handRepository: HandRepository, private val deck: Deck) {

    fun doAction(): Int {
        return handRepository.findAll().filter { deck.chooseAWinner(it) == Player.PLAYER_1 }.count()
    }

}