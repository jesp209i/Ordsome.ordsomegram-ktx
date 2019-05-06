package dk.enmango.ordsomegram.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.AnswerCallback
import dk.enmango.ordsomegram.services.RequestRepository
import dk.enmango.ordsomegram.ui.adapters.RequestDetailAnswerAdapter
import dk.enmango.ordsomegram.viewmodel.RequestDetailViewModel
import dk.enmango.ordsomegram.viewmodel.RequestListViewModel
import org.koin.android.ext.android.inject

class MyRequestDetail : Fragment(){
    private lateinit var requestDetailVM: RequestDetailViewModel
    private lateinit var ans_org_text: TextView
    private lateinit var ans_source_lan_tv: TextView
    private lateinit var ans_target_lan_tv: TextView
    private lateinit var request_open_tv: TextView
    private lateinit var recyclerView: RecyclerView

    private val answerList : ArrayList<Answer> = arrayListOf()
    private var requestId: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val args = MyRequestDetailArgs.fromBundle(it)
            requestId = args.requestId
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_request_detail, container, false)
        recyclerView = view.findViewById<RecyclerView>(R.id.answerRecyclerView)
        recyclerView.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = RequestDetailAnswerAdapter(answerList, context!!)
        }
        assignViews(view)
        initViewModel(requestId!!)
        request_open_tv.setOnClickListener{
                Toast.makeText(context, "You clicked on openclosed request", Toast.LENGTH_LONG).show()
            requestDetailVM.changeRequestStatus()
        }
        return view
    }

    private fun initViewModel(requestId: Int) {
        requestDetailVM = ViewModelProviders.of(this).get(RequestDetailViewModel::class.java)
        requestDetailVM.fragmentTitle.observe(this, Observer {
            activity?.title = it
        })
        requestDetailVM.let {
            it.getRequestDetails(requestId)
            it.originalRequestText.observe(this, Observer {
                ans_org_text.text = it
            })
            it.sourceLanguage.observe(this, Observer{
                ans_source_lan_tv.text = it
            })
            it.targetLanguage.observe(this, Observer{
                ans_target_lan_tv.text = it
            })
            it.answerList.observe(this, Observer {
                answerList.clear()
                answerList.addAll(it)
                recyclerView.adapter?.notifyDataSetChanged()
            })
            it.closedRequest.observe(this, Observer{
                request_open_tv.text = it
            })
        } // end of let
    }

    fun assignViews(view:View){
        ans_org_text = view.findViewById<TextView>(R.id.answered_original_text)
        ans_source_lan_tv = view.findViewById<TextView>(R.id.answered_original_textview)
        ans_target_lan_tv = view.findViewById<TextView>(R.id.answered_translated_textview)
        request_open_tv = view.findViewById<TextView>(R.id.request_open_textview)
    }

}
