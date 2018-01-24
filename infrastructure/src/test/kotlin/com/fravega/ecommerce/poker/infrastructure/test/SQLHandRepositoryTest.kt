package com.fravega.ecommerce.poker.infrastructure.test

internal class SQLHandRepositoryTest {

    /*private lateinit var path: String
    private lateinit var SQLHandRepository: SQLHandRepository
    private var handFactory = HandFactory()

    @Test
    fun aFileShouldBeLoaded() {
        givenAHandsFile()

        whenTheFileIsLoaded()

        thenHandsWasReadOK()
    }

    private fun givenAHandsFile() {
        path = "src/test/resources/poker.txt"
    }

    private fun whenTheFileIsLoaded() {
        SQLHandRepository = SQLHandRepository(path, handFactory)
    }

    private fun thenHandsWasReadOK() {
        val handPairs = SQLHandRepository.findAll()
        assertThat(handPairs).hasSize(5)
        handPairs.forEach {
            assertThat(it.first).isEqualTo(firstHand())
            assertThat(it.second).isEqualTo(secondHand())
        }
    }

    private fun firstHand(): Hand {
        return handFactory.clasify(listOf(
                Card(CardValue.EIGHT, Suit.CLUBS),
                Card(CardValue.TEN, Suit.SPADES),
                Card(CardValue.KING, Suit.CLUBS),
                Card(CardValue.NINE, Suit.HEARTS),
                Card(CardValue.FOUR, Suit.SPADES)
        ))
    }

    private fun secondHand(): Hand {
        return handFactory.clasify(listOf(
                Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.SPADES),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.SPADES),
                Card(CardValue.ACE, Suit.CLUBS)
        ))
    }
    */

}