package dk.enmango.ordsomegram.model

import java.util.ArrayList

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<Request> = ArrayList()
    val pleaseTanslate: MutableList<String> = mutableListOf("Die Pferde sind schön", "Thanks for dinner", "Yksi kaksi kolme", "Ding dong daeh", "Pumpulivanua", "Arret", "Find Holger", "sludder", "Poutine", "Thanks for all the fish", "Das Leiden des jungen Werthers", "Sturm und Drang", "The apple doesn't fall far from the three", "Det peljer far at gøre", "Er I glar")
    val lanOrigin: MutableList<String> = mutableListOf("Tysk", "Engelsk", "Finsk", "Kinesisk", "Finsk", "Canadisk-fransk", "Dansk", "Dansk", "Canadisk-fransk", "Engelsk", "Tysk", "Tysk", "Engelsk", "Dansk", "Sidney Lee")
    val lanTarget: MutableList<String> = mutableListOf("Dansk", "Dansk", "Dansk", "Dansk", "Dansk", "Dansk", "Spansk", "Engelsk", "Dansk", "Dansk", "Dansk", "Dansk", "Dansk", "Engelsk", "Dansk")

    private val COUNT = pleaseTanslate.size

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(
                createDummyRequest(i)
            )
        }
    }

    private fun addItem(item: Request) {
        ITEMS.add(item)
    }

    private fun createDummyRequest(position: Int): Request {
        return Request(null, pleaseTanslate[position], lanOrigin[position], lanTarget[position])
    }

}
