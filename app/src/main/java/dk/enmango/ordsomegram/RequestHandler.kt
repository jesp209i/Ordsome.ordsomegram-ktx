package dk.enmango.ordsomegram

import dk.enmango.ordsomegram.model.Request

class RequestHandler{
    fun createTranslationRequest(
        textToTranslate : String,
        languageOrigin : String,
        languageTarget : String)
    {
        var translationRequest = Request(null,textToTranslate , languageOrigin, languageTarget)
        // send to server somehow
        // save locally
    }

    fun saveLocalRequest(request: Request){
        // save in some local list or ?
    }

}