package dk.enmango.ordsomegram.services

import android.util.Log
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.DTO.CreateAnswer
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.AnswerCallback
import dk.enmango.ordsomegram.services.Interfaces.RequestCallback

class RequestRepository(val apiController: APIController): RequestCallback, AnswerCallback {
    private val TAG = RequestRepository::class.java.simpleName
    val requestList: MutableList<Request> = mutableListOf<Request>()

    init {
        apiController.getRequests(this)
        // Sample Static Data
        //requestList.addAll(SampleData.list)
    }
    fun addRequest(request: CreateRequest){
        //val requestCount = requestList.size
        //val newRequest = Request(requestCount,request.textToTranslate,request.languageOrigin,request.languageTarget)
        //requestList.add(newRequest)
        apiController.addToServer(request,this)
    }
    fun findById( id: Int): Request?{
        return requestList.find{ request -> request.requestId == id }
    }
    fun addAnswer(answer: CreateAnswer){
        // val request = findById(answer.requestId)
        // val answerCount = request?.answers?.size
        // val newAnswer = Answer(answerCount!!,answer.textTranslated,answer.requestId)
        // request.answers.add(newAnswer)
        apiController.addToServer(answer,this)
    }
    fun getAnswers(requestId: Int, answerCallback: AnswerCallback) {
        apiController.getAnswers(requestId, answerCallback)
    }
    override fun onSuccessRequestList(response: MutableList<Request>) {
        requestList.clear()
        requestList.addAll(response)
        Log.d(TAG,"requestList refreshed from server")
    }
    override fun onSuccessAnswerList(requestId: Int, response: MutableList<Answer>) {
        val request = findById(requestId)
        request?.let {
            it.answers.clear()
            it.answers.addAll(response)
        }
    }
    fun getRequests(callback: RequestCallback?){
        apiController.getRequests(callback)
    }


}
