package dk.enmango.ordsomegram

import android.content.Context
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.ConfigurationCompat
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RequestFragment : Fragment() {
    private val TAG = RequestFragment::class.java.simpleName
    private var sendButton: Button? = null
    private var textToTranslateBox: EditText? = null
    private var languageOrigin = "engelsk"
    private var languageTarget = "dansk"
    private var locale: Locale? = null
    private var targetLanguageSuggestionTB: TextView? = null
    private var sourceLangEditText: EditText? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView: View = inflater.inflate(R.layout.fragment_request, container, false)
        sourceLangEditText = fragmentView.findViewById(R.id.request_source_language_edittext)
        locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0)
        languageTarget = locale!!.getDisplayName()
        sendButton = fragmentView.findViewById(R.id.request_button)
        targetLanguageSuggestionTB = fragmentView.findViewById(R.id.request_suggested_language_target_text)
        targetLanguageSuggestionTB!!.text = languageTarget

        textToTranslateBox = fragmentView.findViewById(R.id.request_source_text)

        sendButton!!.setOnClickListener{
            val textToTranslate = textToTranslateBox!!.text
            languageOrigin = sourceLangEditText?.text.toString()
            val toastText = "textToTranslate: $textToTranslate languageOrigin: $languageOrigin languageTarget: $languageTarget"
            val duration = Toast.LENGTH_LONG
            Toast.makeText(context,toastText,duration).show()
            //languageOrigin = request_source_language_edittext
            Log.d(TAG, "onClickListener clicked! textToTranslate: $textToTranslate languageOrigin: $languageOrigin languageTarget: $languageTarget")
            clearEdittexts()
        }
        return fragmentView
    }

    fun clearEdittexts(){
        sourceLangEditText?.text?.clear()
        textToTranslateBox?.text?.clear()

    }

}
