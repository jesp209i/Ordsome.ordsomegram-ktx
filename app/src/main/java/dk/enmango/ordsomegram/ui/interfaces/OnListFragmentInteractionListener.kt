package dk.enmango.ordsomegram.ui.interfaces

import dk.enmango.ordsomegram.model.Request

interface OnListFragmentInteractionListener {
    // TODO: Update argument type and name
    fun <T> onListFragmentInteraction(item: Request?, caller: T)
}