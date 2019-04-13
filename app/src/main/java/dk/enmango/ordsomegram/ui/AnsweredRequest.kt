package dk.enmango.ordsomegram.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.services.RequestRepository
import dk.enmango.ordsomegram.ui.adapters.AnswerAdapter
import org.koin.android.ext.android.inject

class AnsweredRequest : Fragment() {
    private val requestRepo: RequestRepository by inject()

    private var requestId: Int? = null
    private lateinit var ans_org_text: TextView
    private lateinit var ans_trans_text: TextView
    private lateinit var ans_source_lan_tv: TextView
    private lateinit var ans_target_lan_tv: TextView
    private var origText: String? = null
    private var sourceLang: String? = null
    private var targetLang: String? = null
    private val answerList : ArrayList<Answer> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val args = AnsweredRequestArgs.fromBundle(it)
            requestId = args.requestId
        }
        populateProperties()
    }

    private fun populateProperties() {
        val request = requestRepo.findById(requestId!!)
        //Toast.makeText(context, "$request", Toast.LENGTH_LONG).show()
        origText = request!!.textToTranslate
        answerList.addAll(request.answers)
        sourceLang = request.languageOrigin
        targetLang = request.languageTarget
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_answered_request, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.answerRecyclerView)
        recyclerView.layoutManager =  LinearLayoutManager(context)
        recyclerView.adapter = AnswerAdapter(answerList, context!!)
        assignViews(view)
        setViewValues()
        return view
    }

    fun setViewValues(){
        val sourceLanguage = getString(R.string.answered_original_textview, sourceLang)
        val targetLanguage = getString(R.string.answered_translated_textview, targetLang)
        ans_org_text.text = origText
        ans_source_lan_tv.text = sourceLanguage
        ans_target_lan_tv.text = targetLanguage
    }

    fun assignViews(view:View){
        ans_org_text = view.findViewById<TextView>(R.id.answered_original_text)
        ans_source_lan_tv = view.findViewById<TextView>(R.id.answered_original_textview)
        ans_target_lan_tv = view.findViewById<TextView>(R.id.answered_translated_textview)
    }

}
