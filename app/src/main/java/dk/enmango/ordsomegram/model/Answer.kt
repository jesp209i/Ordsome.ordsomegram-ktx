package dk.enmango.ordsomegram.model

data class Answer(
    var id: String?,
    val translation: String,
    val requestId: String)