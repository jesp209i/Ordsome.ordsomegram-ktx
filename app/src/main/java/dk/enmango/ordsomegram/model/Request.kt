package dk.enmango.ordsomegram.model

data class Request(
    override var id: String?,
    var textToTranslate: String,
    var languageOrigin: String,
    var languageTarget: String
): IEntity {
    override fun toString(): String {
        return "Request(id=$id, textToTranslate='$textToTranslate', languageOrigin='$languageOrigin', languageTarget='$languageTarget')"
    }
}