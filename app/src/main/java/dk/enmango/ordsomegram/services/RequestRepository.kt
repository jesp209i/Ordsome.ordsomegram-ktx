package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.Request

class RequestRepository : IRequestRepository{
    companion object {
        var requests = mutableListOf<Request>()
    }

    override fun addRequest(request: Request){
        request.id = findNextNumber()
        requests.add(request)
    }
    override fun findNextNumber() : Int {
        return requests.size
    }
    override fun getAllRequest() : MutableList<Request> {
        return requests
    }
    override fun findRequestById(id: Int) : Request? {
        val request = requests.find{ request -> request.id == id }
        return request
    }



}

