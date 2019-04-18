package dk.enmango.ordsomegram.services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dk.enmango.ordsomegram.model.DTO.CreateAnswer
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.model.Request
import org.json.JSONObject

object JSONConvert {
    fun jsonToList(string: String) : MutableList<Request> {
        val gson: Gson = Gson()
        val listType = object : TypeToken<MutableList<Request>>() { }.type
        val realRequests: MutableList<Request> = gson.fromJson(string,listType)
        return realRequests
    }
    fun requestToJSONObject(model: CreateRequest) : JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("languageOrigin", model.languageOrigin)
        jsonObject.put("languageTarget", model.languageTarget)
        jsonObject.put("textToTranslate", model.textToTranslate)
        return jsonObject
    }
    fun answerToJSONObject(model: CreateAnswer) : JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("requestId", model.requestId)
        jsonObject.put("textTranslated", model.textTranslated)
        return jsonObject
    }
}