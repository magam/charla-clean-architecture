package com.fravega.ecommerce.poker.infrastructure.data.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Cards")
internal data class CardEntity(
        @Id
        @GeneratedValue
        val id: Long? = null,
        val card1: String = "",
        val card2: String = "",
        val card3: String = "",
        val card4: String = "",
        val card5: String = "",
        val card6: String = "",
        val card7: String = "",
        val card8: String = "",
        val card9: String = "",
        val card10: String = "")