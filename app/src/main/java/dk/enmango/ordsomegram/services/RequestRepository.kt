package dk.enmango.ordsomegram.services

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley.newRequestQueue
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.DTO.CreateAnswer
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.ServerCallback

class RequestRepository(val apiController: APIController): ServerCallback {
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
        apiController.addRequest(request)
    }
    fun findById( id: Int): Request?{
        return requestList.find{ request -> request.id == id }
    }
    fun addAnswer(answer: CreateAnswer){
        val request = findById(answer.requestId)
        val answerCount = request?.answers?.size
        val newAnswer = Answer(answerCount!!,answer.translation,answer.requestId)
        request.answers.add(newAnswer)
    }
    override fun onSuccessRequestList(response: MutableList<Request>) {
        requestList.clear()
        requestList.addAll(response)
    }

}
