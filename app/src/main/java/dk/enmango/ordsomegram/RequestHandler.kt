package dk.enmango.ordsomegram

import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.IRequestRepository

class RequestHandler(val requestRepo: IRequestRepository){

    fun createTranslationRequest(
        textToTranslate : String,
        languageOrigin : String,
        languageTarget : String)
    {
        val translationRequest = Request(null,textToTranslate , languageOrigin, languageTarget)
        // send to server somehow
        // save locally
        saveLocalRequest(translationRequest)
    }

    fun saveLocalRequest(request: Request){
        requestRepo.addRequest(request)
    }
}