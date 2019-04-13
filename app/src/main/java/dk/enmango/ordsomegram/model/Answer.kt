package dk.enmango.ordsomegram.model

data class Answer(
    var id: Int,
    val translation: String,
    val requestId: Int)