package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.IEntity
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.IRepository

class RequestHandler(val requestRepo: IRepository<IEntity>){

    /*   fun createRequest(
           textToTranslate : String,
           languageOrigin : String,
           languageTarget : String)
       {
           val translationRequest = Request(null,textToTranslate , languageOrigin, languageTarget)
           // send to server somehow
           // save locally
           saveRequest(translationRequest)
       }

       fun saveRequest(request: Request){
           requestRepo.addRequest(request)
       }
       fun getRequests(): MutableList<Request>{
           return requestRepo.getAllRequest()
       }
       fun findRequest(id: String):Request?{
           return requestRepo.findRequestById(id)
       }
       fun saveAnswer(answer: Answer){

       }*/

}