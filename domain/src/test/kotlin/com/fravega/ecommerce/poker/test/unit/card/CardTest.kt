package com.fravega.ecommerce.poker.test.unit.card

import com.fravega.ecommerce.poker.domain.hands.Card
import com.fravega.ecommerce.poker.domain.hands.CardValue
import com.fravega.ecommerce.poker.domain.hands.Suit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.Test
import java.math.BigInteger

internal class CardTest {

    private lateinit var value: BigInteger
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
        value = BigInteger("4")
        cardSuit = "S"
    }

    private fun givenAInvalidValue() {
        value = BigInteger("99")
    }

    private fun whenTheseValuesAreUsed() {
        card = Card(CardValue.fromValue(value.intValueExact()), Suit.fromCode(cardSuit))
    }

    private fun whenTheseValueIsUsed() {
        thrown = catchThrowable { CardValue.fromValue(value.intValueExact()) }
    }

    private fun thenACardIsConstructed() {
        assertThat(card).isEqualTo(Card(CardValue.FOUR, Suit.SPADES))
    }

    private fun thenCardValueConstructionHasFailed() {
        assertThat(thrown).hasMessage("Array contains no element matching the predicate.")
    }
}
