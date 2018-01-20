package com.fravega.ecommerce.poker.test.unit.actions

import com.fravega.ecommerce.poker.domain.actions.CalculateWinner
import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.domain.model.Player
import com.fravega.ecommerce.poker.test.doubles.InMemoryHandRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class CalculateWinnerTest {

    private lateinit var aHandRepository: HandRepository
    private lateinit var calculateWinner: CalculateWinner
    private lateinit var winner: Player

    @Test
    fun player2ShouldBeTheWinner() {
        givenAHandRepository()
        givenAConfiguredAction()

        whenCalculateWinner()

        thenPlayer2WasTheWinner()
    }

    private fun givenAHandRepository() {
        aHandRepository = InMemoryHandRepository()
    }

    private fun givenAConfiguredAction() {
        calculateWinner = CalculateWinner(aHandRepository, Deck())
    }

    private fun whenCalculateWinner() {
        winner = calculateWinner.doAction()
    }

    private fun thenPlayer2WasTheWinner() {
        assertThat(winner).isEqualTo(Player.PLAYER_2)
    }


}