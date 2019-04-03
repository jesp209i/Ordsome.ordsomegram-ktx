package dk.enmango.ordsomegram.model

data class Request(
    var id: String?,
    var textToTranslate: String,
    var languageOrigin: String,
    var languageTarget: String,
    val answers: MutableList<Answer> = mutableListOf()
) {
    override fun toString(): String {
        return "Request(id=$id, textToTranslate='$textToTranslate', languageOrigin='$languageOrigin', languageTarget='$languageTarget', noOfAnswers='${answers.size}')"
    }
}