package dk.enmango.ordsomegram.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.ui.adapters.RecyclerViewAdapterWithListFragmentListener
import dk.enmango.ordsomegram.ui.interfaces.OnListFragmentInteractionListener
import dk.enmango.ordsomegram.viewmodel.AnswersViewModel

class AnswersFragment : Fragment() {
    private var answersVM: AnswersViewModel? = null
    val requestList: ArrayList<Request> = arrayListOf<Request>()
    private var listenerAnswer: OnListFragmentInteractionListener? = null
    private var mAdapter: RecyclerViewAdapterWithListFragmentListener<AnswersFragment>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_request_detail_answer_list, container, false)
        if (view is RecyclerView) {
                view.layoutManager = LinearLayoutManager(context)
                mAdapter = RecyclerViewAdapterWithListFragmentListener<AnswersFragment>(requestList, listenerAnswer, context!!, this)
            view.adapter = mAdapter
        }
        initViewModel()
        return view
    }
    private fun initViewModel() {
        answersVM = ViewModelProviders.of(this).get(AnswersViewModel::class.java)
        val listObserver: Observer<MutableList<Request>> = Observer{
            requestList.clear()
            requestList.addAll(it)
            mAdapter?.notifyDataSetChanged()
        }
        answersVM?.let {
            it.requestList.observe(this,listObserver)
            it.fragmentTitle.observe(this, Observer{
                activity?.title = it
            })
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listenerAnswer = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnAnswerListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerAnswer = null
    }

}
