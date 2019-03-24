package dk.enmango.ordsomegram.model

data class AnsweredRequest(val request: Request): IEntity{
    override var id: String? = request.id!!
   // var MutableList<Answer> answers = mutableListOf<>()
}
