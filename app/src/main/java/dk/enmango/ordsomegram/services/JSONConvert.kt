package dk.enmango.ordsomegram.services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.DTO.AnswerIsPreffered
import dk.enmango.ordsomegram.model.DTO.CreateAnswer
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.model.DTO.RequestChangeStatus
import dk.enmango.ordsomegram.model.Request
import org.json.JSONObject

object JSONConvert {
    fun jsonToRequestList(string: String): MutableList<Request> {
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
    fun requestChangeStatusToJSONObject(model: RequestChangeStatus): JSONObject{
        val jsonObject = JSONObject()
        jsonObject.put("requestId", model.requestId)
        jsonObject.put("isClosed",model.isClosed)
        return jsonObject
    }
    fun answerIsPrefferedToJSONObject(model: AnswerIsPreffered): JSONObject{
        val jsonObject = JSONObject()
        jsonObject.put("requestId", model.requestId)
        jsonObject.put("answerId", model.answerId)
        jsonObject.put("isPreferred",model.isPreferred)
        return jsonObject
    }

    fun jsonToAnswerList(string: String): MutableList<Answer> {
        val gson: Gson = Gson()
        val listType = object : TypeToken<MutableList<Answer>>() { }.type
        val realAnswers: MutableList<Answer> = gson.fromJson(string,listType)
        return realAnswers
    }
}