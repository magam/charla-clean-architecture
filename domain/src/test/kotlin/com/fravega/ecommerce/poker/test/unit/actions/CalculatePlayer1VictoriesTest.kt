package com.fravega.ecommerce.poker.test.unit.actions

import com.fravega.ecommerce.poker.domain.actions.CalculatePlayer1Victories
import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.test.doubles.InMemoryHandRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class CalculatePlayer1VictoriesTest {

    private lateinit var aHandRepository: HandRepository
    private lateinit var calculatePlayer1VictoriesAction: CalculatePlayer1Victories
    private var player1WinsHands = 0

    @Test
    fun player1MustWinThreeTimes() {
        givenAHandRepository()
        givenAConfiguredAction()

        whenCalculatePlayer1Victories()

        thenPlayer1WinsThreeTimes()
    }

    private fun givenAHandRepository() {
        aHandRepository = InMemoryHandRepository()
    }

    private fun givenAConfiguredAction() {
        calculatePlayer1VictoriesAction = CalculatePlayer1Victories(aHandRepository, Deck())
    }

    private fun whenCalculatePlayer1Victories() {
        player1WinsHands = calculatePlayer1VictoriesAction.doAction()
    }

    private fun thenPlayer1WinsThreeTimes() {
        assertThat(player1WinsHands).isEqualTo(3)
    }

}