package dk.enmango.ordsomegram.services.Interfaces

import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.Request
import org.json.JSONObject

interface RequestCallback {
    fun onSuccessRequestList(response: MutableList<Request>)
}
interface AnswerCallback {
    fun onSuccessAnswerList(requestId: Int, response: MutableList<Answer>)
}