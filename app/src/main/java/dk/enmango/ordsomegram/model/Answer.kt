package dk.enmango.ordsomegram.model

data class Answer(
    val answerId: Int,
    val textTranslated: String,
    val requestId: Int,
    var isPreferred: Boolean)