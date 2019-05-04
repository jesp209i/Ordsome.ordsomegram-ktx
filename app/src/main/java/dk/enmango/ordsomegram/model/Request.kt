package dk.enmango.ordsomegram.model

data class Request(
    var requestId: Int,
    var textToTranslate: String,
    var languageOrigin: String,
    var languageTarget: String,
    var noOfAnswers: Int,
    var isClosed: Boolean
) {
    val answers: MutableList<Answer> = mutableListOf()
    override fun toString(): String {
        return "Request(id=$requestId, textToTranslate='$textToTranslate', languageOrigin='$languageOrigin', languageTarget='$languageTarget', noOfAnswers='${noOfAnswers}', isClosed='${isClosed}')"
    }
}