package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.DTO.CreateAnswer
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.model.Request


class RequestRepository {
    val requestList: MutableList<Request> = mutableListOf<Request>()
    init {
        // Sample Static Data
        requestList.addAll(SampleData.list)
    }
    fun addRequest(request: CreateRequest){
        val requestCount = requestList.size
        val newRequest = Request(requestCount,request.textToTranslate,request.languageOrigin,request.languageTarget)
        requestList.add(newRequest)
    }
    fun findById( id: Int): Request?{
        return requestList.find{ request -> request.id == id }
    }
    fun addAnswer(answer: CreateAnswer){
        val request = findById(answer.requestId)
        val answerCount = request?.answers?.size
        val newAnswer = Answer(answerCount!!,answer.translation,answer.requestId)
        request?.answers?.add(newAnswer)
    }
}
