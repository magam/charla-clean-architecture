package com.fravega.ecommerce.poker.test.unit.hands

import com.fravega.ecommerce.poker.domain.hands.*
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
        hand = Hand(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES)))
    }

    private fun whenResolveHandValue() {
        handValue = hand.value
    }

    private fun thenAPairIsResolved() {
        assertThat(handValue).isEqualTo(HandValue.PAIR)
    }

}


