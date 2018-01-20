package com.fravega.ecommerce.poker.infrastructure.rest

import com.fravega.ecommerce.poker.domain.actions.CalculatePlayer1Victories
import javax.ws.rs.core.Response
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/player1")
@Produces(MediaType.APPLICATION_JSON_UTF_8)
@Consumes(MediaType.APPLICATION_JSON_UTF_8)
internal class Player1VictoriesResource(private val calculatePlayer1Victories: CalculatePlayer1Victories) {

    @GET
    @Path("/wins")
    fun getPlayer1Wins(): Response {
        return try {
            Response.ok(Player1WinsResponse(calculatePlayer1Victories.doAction())).build()
        } catch (e: Exception) {
            Response.serverError().entity(e.message).build()
        }
    }

    data class Player1WinsResponse(val amount: Int)

}