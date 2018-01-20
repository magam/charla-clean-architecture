package com.fravega.ecommerce.poker.domain.model

interface HandRepository {

    fun findAll(): List<Pair<Hand, Hand>>

}