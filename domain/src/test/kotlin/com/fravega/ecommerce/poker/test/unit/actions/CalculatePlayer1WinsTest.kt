package com.fravega.ecommerce.poker.test.unit.actions

import com.fravega.ecommerce.poker.domain.actions.CalculatePlayer1Wins
import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.test.doubles.InMemoryHandRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class CalculatePlayer1WinsTest {

    private lateinit var aHandRepository: HandRepository
    private lateinit var calculatePlayer1WinsAction: CalculatePlayer1Wins
    private var player1WinsHands = 0

    @Test
    fun player1MustWinThreeTimes() {
        givenAHandRepository()
        givenAConfiguredAction()

        whenCalculatePlayer1Wins()

        thenPlayer1WinsThreeTimes()
    }

    private fun givenAHandRepository() {
        aHandRepository = InMemoryHandRepository()
    }

    private fun givenAConfiguredAction() {
        calculatePlayer1WinsAction = CalculatePlayer1Wins(aHandRepository, Deck())
    }

    private fun whenCalculatePlayer1Wins() {
        player1WinsHands = calculatePlayer1WinsAction.doAction()
    }

    private fun thenPlayer1WinsThreeTimes() {
        assertThat(player1WinsHands).isEqualTo(3)
    }

}