package com.fravega.ecommerce.poker.domain

enum class Player {
    PLAYER_1, PLAYER_2
}

internal class Deck {

    fun chooseAWinner(hands: Pair<Hand, Hand>): Player {
        return when {
            hands.first.points > hands.second.points -> Player.PLAYER_1
            hands.second.points > hands.first.points -> Player.PLAYER_2
            else -> tieBreak(hands)
        }
    }

    private fun tieBreak(hands: Pair<Hand, Hand>): Player {
        return when (hands.first) {
            is Hand.RoyalFlush -> Player.PLAYER_1
            else -> hightCardTieBreaker(hands.first, hands.second)
        }
    }

    private fun hightCardTieBreaker(hand1: Hand, hand2: Hand): Player {
        for (i in 0 until hand1.cards.size) {
            if(hand1.sortedCards[i].cardValue.points > hand2.sortedCards[i].cardValue.points) {
                return Player.PLAYER_1
            } else if(hand2.sortedCards[i].cardValue.points > hand1.sortedCards[i].cardValue.points){
                return Player.PLAYER_2
            }
        }
        return Player.PLAYER_1
    }
}