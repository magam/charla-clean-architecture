package com.fravega.ecommerce.poker.domain.actions

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.domain.model.Player

class CalculateWinner(private val handRepository: HandRepository, private val deck: Deck) {

    fun doAction(): Player {
        val listOfHands = handRepository.findAll()
        val listOfVictories = listOfHands.map { deck.chooseAWinner(it) }.groupBy { it }

        val player1Victories = listOfVictories.getOrDefault(Player.PLAYER_1, listOf()).size
        val player2Victories = listOfVictories.getOrDefault(Player.PLAYER_2, listOf()).size

        return if (player1Victories > player2Victories) {
            Player.PLAYER_1
        } else {
            Player.PLAYER_2
        }
    }

}