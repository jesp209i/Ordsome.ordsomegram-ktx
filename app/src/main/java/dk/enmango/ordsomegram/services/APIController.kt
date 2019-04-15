package dk.enmango.ordsomegram.services

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.ServerCallback
import org.json.JSONObject

class APIController(val appContext: Context) {
    private val TAG = APIController::class.java.simpleName
    private val volleyQueue = Volley.newRequestQueue(appContext)
    private val BASE_URL: String = "http://10.0.2.2:58882/api/"
    private val CREATE_REQUEST: String = "requests/create"
    private val GET_ALL_REQUESTS: String = "requests/getall"
    private val CREATE_ANSWER: String = "answers/create"

    fun getRequests(callback: ServerCallback? = null){
        val stringRequest = StringRequest(
            com.android.volley.Request.Method.GET, "${BASE_URL + GET_ALL_REQUESTS}",
            Response.Listener<String> {
                val gson: Gson = Gson()
                var realRequests = mutableListOf<Request>()
                val listType = object : TypeToken<MutableList<Request>>() { }.type
                realRequests = gson.fromJson(it,listType)
                Log.d(TAG, "${realRequests.toString()}")
                callback?.onSuccessRequestList(realRequests)
            },
            Response.ErrorListener { Log.d(TAG, "That didn't work $it") }
        )
        volleyQueue.add(stringRequest)
    }

    fun addRequest(request: CreateRequest) {
        val jsonObject = modelToJSONObject(request)

        val jsonRequest = JsonObjectRequest(
            com.android.volley.Request.Method.POST,"${BASE_URL + CREATE_REQUEST}", jsonObject,
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
    }

    private fun modelToJSONObject(model: CreateRequest) : JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("languageOrigin", model.languageOrigin)
        jsonObject.put("languageTarget", model.languageTarget)
        jsonObject.put("textToTranslate", model.textToTranslate)
        return jsonObject

    }

}