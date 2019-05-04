package dk.enmango.ordsomegram.ui.interfaces

import dk.enmango.ordsomegram.model.Request

interface OnListFragmentInteractionListener {
    fun <T> onListFragmentInteraction(item: Request?, caller: T)
}