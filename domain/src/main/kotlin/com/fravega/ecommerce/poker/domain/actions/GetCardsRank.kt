package com.fravega.ecommerce.poker.domain.actions

import com.fravega.ecommerce.poker.domain.model.Card
import com.fravega.ecommerce.poker.domain.model.HandRepository

class GetCardsRank(private val handRepository: HandRepository) {

    fun doAction(): Map<Card, Int> {
        return handRepository.findAll().map {
            it.first.cards.plus(it.second.cards)
        }.flatten().groupingBy { it }.eachCount().toList().sortedByDescending { (_, value) -> value }.toMap()
    }
}