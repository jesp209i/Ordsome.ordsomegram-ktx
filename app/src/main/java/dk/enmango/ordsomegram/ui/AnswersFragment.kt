package dk.enmango.ordsomegram.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.RequestRepository
import dk.enmango.ordsomegram.ui.adapters.AnswerListAdapter
import org.koin.android.ext.android.inject

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [AnswersFragment.OnAnswerListFragmentInteractionListener] interface.
 */
class AnswersFragment : Fragment() {

    val requestRepo: RequestRepository by inject()

    val list: ArrayList<Request> = requestRepo.requestList as ArrayList<Request>
    // TODO: Customize parameters
    private var columnCount = 1

    private var listenerAnswer: OnAnswerListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_answers_list, container, false)
        if (view is RecyclerView) {
                view.layoutManager = LinearLayoutManager(context)
                view.adapter = AnswerListAdapter(list, listenerAnswer, context!!)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAnswerListFragmentInteractionListener) {
            listenerAnswer = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnAnswerListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerAnswer = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnAnswerListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onAnswerListFragmentInteraction(item: Request?)
    }
}
