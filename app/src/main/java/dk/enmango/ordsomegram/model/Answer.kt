package dk.enmango.ordsomegram.model

data class Answer(
    var id: Int,
    val textTranslated: String,
    val requestId: Int)