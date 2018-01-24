package com.fravega.ecommerce.poker.domain.actions

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.domain.model.Player

class CalculatePlayerOneVictories(private val handRepository: HandRepository, private val deck: Deck) {

    fun doAction(): Int {
        return handRepository.findAll().filter { deck.chooseAWinner(it) == Player.PLAYER_1 }.count()
    }

}