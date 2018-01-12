package com.fravega.ecommerce.poker.test.unit.hands

import com.fravega.ecommerce.poker.domain.hands.Card
import com.fravega.ecommerce.poker.domain.hands.CardValue
import com.fravega.ecommerce.poker.domain.hands.Hand
import com.fravega.ecommerce.poker.domain.hands.HandValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class HandOfPairTest {

    private lateinit var hand: Hand
    private lateinit var handValue: HandValue

    @Test
    fun aPairShouldBeResolved() {
        givenAHandWithAPair()

        whenResolveHandValue()

        thenAPairIsResolved()
    }


    private fun givenAHandWithAPair() {
        hand = Hand(listOf(Card(CardValue.TWO), Card(CardValue.THREE), Card(CardValue.FOUR), Card(CardValue.FIVE), Card(CardValue.FIVE)))
    }

    private fun whenResolveHandValue() {
        handValue = hand.value
    }

    private fun thenAPairIsResolved() {
        assertThat(handValue).isEqualTo(HandValue.PAIR)
    }

}


