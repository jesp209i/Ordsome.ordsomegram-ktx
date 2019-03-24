package dk.enmango.ordsomegram.model

data class Answer(
    override var id: String?,
    val translation:
    String, val requestId: String): IEntity