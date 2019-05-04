package dk.enmango.ordsomegram.ui

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.ConfigurationCompat
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.DTO.CreateRequest
import dk.enmango.ordsomegram.services.RequestRepository
import org.koin.android.ext.android.inject
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RequestFragment : Fragment() {
    private val fragmentTitle: String = "Ny forespørgsel"
    private val TAG = RequestFragment::class.java.simpleName
    private val requestRepo: RequestRepository by inject()
    private var sendButton: Button? = null
    private var textToTranslateBox: EditText? = null
    private var languageOrigin = "engelsk"
    private var languageTarget = "Dansk"
    private var targetLanguageSuggestionTB: TextView? = null
    private var sourceLangEditText: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_new_request, container, false)
        activity?.title = fragmentTitle
        setupViews(view)

        sendButton!!.setOnClickListener{
            requestRepo.addRequest(createRequest())

            Toast.makeText(context,"Din forespørgsel blev oprettet",Toast.LENGTH_LONG).show()
            Log.d(TAG, "onClickListener clicked!")

            clearEdittexts()
        }
        return view
    }

    private fun clearEdittexts(){
        sourceLangEditText?.text?.clear()
        textToTranslateBox?.text?.clear()
    }

    private fun createRequest(): CreateRequest {
        val textToTranslate: String = textToTranslateBox?.text.toString()
        languageOrigin = sourceLangEditText?.text.toString()
        val req = CreateRequest(textToTranslate, languageOrigin,languageTarget)
        return req
    }

    private fun setupViews(view:View){
        sourceLangEditText = view.findViewById(R.id.request_source_language_edittext)
        sendButton = view.findViewById(R.id.request_button)
        targetLanguageSuggestionTB = view.findViewById(R.id.request_suggested_language_target_text)
        textToTranslateBox = view.findViewById(R.id.request_source_text)
        languageTarget = getLanguageFromSystem()
        targetLanguageSuggestionTB!!.text = languageTarget

    }
    private fun getLanguageFromSystem(): String{
        val locale: Locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0)
        val langTarget = locale.getDisplayName()
        return langTarget
    }

}
