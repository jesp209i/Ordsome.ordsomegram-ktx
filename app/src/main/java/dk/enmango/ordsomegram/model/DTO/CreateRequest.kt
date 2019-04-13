package dk.enmango.ordsomegram.model.DTO

data class CreateRequest(
    var textToTranslate: String,
    var languageOrigin: String,
    var languageTarget: String
)