package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.Request


class RequestRepository {
    val requestList: MutableList<Request> = mutableListOf<Request>()
    init {
        // Sample Static Data
        requestList.addAll(SampleData.list)
    }
    private fun addRequest(request: Request){
    //    requestHandler.saveRequest(request)
        requestList.add(request)
    }
    fun findById( id: String): Request?{
        return requestList.find{ request -> request.id == id }
    }
}
