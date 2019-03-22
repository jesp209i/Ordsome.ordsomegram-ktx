package dk.enmango.ordsomegram.model

data class Request(
    var id: Int?,
    var textToTranslate: String,
    var languageOrigin: String,
    var languageTarget: String)