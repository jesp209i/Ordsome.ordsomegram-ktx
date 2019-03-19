package dk.enmango.ordsomegram.model

data class Request(
    val id: Integer,
    var textToTranslate: String,
    var languageOrigin: String,
    var languageTarget: String)

