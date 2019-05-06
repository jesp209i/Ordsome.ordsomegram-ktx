package dk.enmango.ordsomegram.services

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.DTO.CreateAnswer
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.AnswerCallback
import dk.enmango.ordsomegram.services.Interfaces.RequestCallback
import org.json.JSONObject

class APIController(val appContext: Context) {
    private val TAG = APIController::class.java.simpleName
    private val volleyQueue = Volley.newRequestQueue(appContext)
    private val BASE_REQUEST_URL: String = "http://10.0.2.2:58882/api/request/"
    private val CREATE_REQUEST: String = "requests/create"
    private val GET_ANSWERS: String = "/answers"
    private val CREATE_ANSWER: String = "/answer"
    private val CLOSE_REQUEST: String = "/close"

    fun getRequests(callback: RequestCallback? = null){
        val stringRequest = StringRequest(
            com.android.volley.Request.Method.GET, BASE_REQUEST_URL,
            Response.Listener<String> {
                val realRequests: MutableList<Request> = JSONConvert.jsonToRequestList(it)
                Log.d(TAG, "${realRequests.toString()}")
                callback?.onSuccessRequestList(realRequests)
            },
            Response.ErrorListener { Log.d(TAG, "That didn't work $it") }
        )
        volleyQueue.add(stringRequest)
    }

    fun <T> addToServer(model: T, requestCallback: RequestCallback?) {
        var url: String? = null
        val jsonObject: JSONObject = when(model){
            is CreateAnswer -> {
                url = BASE_REQUEST_URL + model.requestId + CREATE_ANSWER
                JSONConvert.answerToJSONObject(model)
            }
            is CreateRequest -> {
                url = BASE_REQUEST_URL
                JSONConvert.requestToJSONObject(model)
            }
            else -> {
                Log.d(TAG,"You need to submit an object of type CreateAnswer or CreateRequest")
                JSONObject()
            }
        }

        val jsonRequest = JsonObjectRequest(
            com.android.volley.Request.Method.POST,url, jsonObject,
            Response.Listener<JSONObject> {
                try {
                    Log.d(TAG, "Response: $it")
                }catch (e:Exception){
                    Log.d(TAG, "Exception: $e")
                }
            },
            Response.ErrorListener { Log.d(TAG, "That didn't work ${it.message} ||  $jsonObject") }
        )
        volleyQueue.add(jsonRequest)
        getRequests(requestCallback)
    }

    fun getAnswers(requestId: Int, answerCallback: AnswerCallback?) {
        val stringRequest = StringRequest(
            com.android.volley.Request.Method.GET, BASE_REQUEST_URL + requestId + GET_ANSWERS,
            Response.Listener<String> {
                val realAnswers: MutableList<Answer> = JSONConvert.jsonToAnswerList(it)
                Log.d(TAG, "${realAnswers.toString()}")
                answerCallback?.onSuccessAnswerList(requestId, realAnswers)
            },
            Response.ErrorListener { Log.d(TAG, "That didn't work $it") }
        )
        volleyQueue.add(stringRequest)
    }

    fun changeRequestStatus(requestId: Int) {
        val closeUrl = BASE_REQUEST_URL + requestId + CLOSE_REQUEST
        val stringRequest = StringRequest(
            com.android.volley.Request.Method.PATCH, closeUrl,
            Response.Listener<String> {

                Log.d(TAG, "Close Request Patch send")
                },
            Response.ErrorListener { Log.d(TAG, "That didn't work $it") }
        )
        volleyQueue.add(stringRequest)
    }
}