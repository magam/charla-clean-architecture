package com.fravega.ecommerce.poker.test.unit

import com.fravega.ecommerce.poker.domain.Card
import com.fravega.ecommerce.poker.domain.CardValue
import com.fravega.ecommerce.poker.domain.Suit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.Test

internal class CardTest {

    private var value = 0
    private lateinit var cardSuit: String
    private lateinit var card: Card
    private lateinit var thrown: Throwable

    @Test
    fun aCardShouldBeConstructed() {
        givenAPairOfValidValues()

        whenTheseValuesAreUsed()

        thenACardIsConstructed()
    }

    @Test
    fun aInvalidCardValueShouldntBeConstructed() {
        givenAInvalidValue()

        whenTheseValueIsUsed()

        thenCardValueConstructionHasFailed()
    }

    private fun givenAPairOfValidValues() {
        value = 4
        cardSuit = "S"
    }

    private fun givenAInvalidValue() {
        value = 99
    }

    private fun whenTheseValuesAreUsed() {
        card = Card(CardValue.fromValue(value), Suit.fromCode(cardSuit))
    }

    private fun whenTheseValueIsUsed() {
        thrown = catchThrowable { CardValue.fromValue(value) }
    }

    private fun thenACardIsConstructed() {
        assertThat(card).isEqualTo(Card(CardValue.FOUR, Suit.SPADES))
    }

    private fun thenCardValueConstructionHasFailed() {
        assertThat(thrown).hasMessage("Array contains no element matching the predicate.")
    }
}
