package com.fravega.ecommerce.poker.test.unit.actions

import com.fravega.ecommerce.poker.domain.actions.CalculatePlayerOneVictories
import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.test.doubles.InMemoryHandRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class CalculatePlayerOneVictoriesTest {

    private lateinit var aHandRepository: HandRepository
    private lateinit var calculatePlayerOneVictoriesAction: CalculatePlayerOneVictories
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
        calculatePlayerOneVictoriesAction = CalculatePlayerOneVictories(aHandRepository, Deck())
    }

    private fun whenCalculatePlayer1Victories() {
        player1WinsHands = calculatePlayerOneVictoriesAction.doAction()
    }

    private fun thenPlayer1WinsThreeTimes() {
        assertThat(player1WinsHands).isEqualTo(3)
    }

}