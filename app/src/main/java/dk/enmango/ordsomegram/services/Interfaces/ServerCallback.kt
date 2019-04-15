package dk.enmango.ordsomegram.services.Interfaces

import dk.enmango.ordsomegram.model.Request
import org.json.JSONObject

interface ServerCallback {
    fun onSuccessRequestList(response: MutableList<Request>)
}