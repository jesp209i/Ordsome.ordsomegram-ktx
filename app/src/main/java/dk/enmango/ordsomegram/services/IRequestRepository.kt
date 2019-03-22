package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.Request

interface IRequestRepository {
    fun addRequest(request: Request)
    fun findNextNumber() : Int
    fun getAllRequest() : MutableList<Request>
    fun findRequestById(id: Int) : Request?
}