package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.Request


class RequestRepository {
    val requestList: MutableList<Request> = mutableListOf<Request>()
    init {
        // Sample Static Data
        requestList.addAll(SampleData.list)
    }
    fun addRequest(request: Request){
    //    requestHandler.saveRequest(request)
        val requestCount = requestList.size
        request.id = requestCount.toString()
        requestList.add(request)
    }
    fun findById( id: String): Request?{
        return requestList.find{ request -> request.id == id }
    }
    fun addAnswer(answer: Answer){
        val request = findById(answer.requestId)
        val answerCount = request?.answers?.size
        answer.id = answerCount.toString()
        request?.answers?.add(answer)
    }
}
