package dk.enmango.ordsomegram

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.sample.SampleDataProvider

class AnsweredRequest : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var requestId: String
    private lateinit var ans_org_text: TextView
    private lateinit var ans_trans_text: TextView
    private lateinit var ans_source_lan_tv: TextView
    private lateinit var ans_target_lan_tv: TextView
    private var origText: String? = null
    private var transText: String? = null
    private var sourceLang: String? = null
    private var targetLang: String? = null
    private var translatedText: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val args = AnsweredRequestArgs.fromBundle(it)
            origText = args.originalText
            transText = args.translatedText
            sourceLang = args.sourceLang
            targetLang = args.targetLang
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_answered_request, container, false)
        ans_org_text = view.findViewById<TextView>(R.id.answered_original_text)
        ans_trans_text = view.findViewById<TextView>(R.id.answered_translated_text)
        ans_source_lan_tv = view.findViewById<TextView>(R.id.answered_source_language_textview)
        ans_target_lan_tv = view.findViewById<TextView>(R.id.answered_target_language_textview)
        ans_org_text.text = origText
        ans_source_lan_tv.text = sourceLang
        ans_target_lan_tv.text = targetLang
        ans_trans_text.text = transText

        return view
    }

}
