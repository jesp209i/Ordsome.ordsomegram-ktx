package dk.enmango.ordsomegram.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.DTO.CreateAnswer
import dk.enmango.ordsomegram.services.RequestRepository
import org.koin.android.ext.android.inject


class CreateAnswerFragment : Fragment() {
    private val requestRepo: RequestRepository by inject()
    private val fragmentTitle = "Besvar forespørgsel"
    private var requestId: Int? = null
    private var origText: String? = null
    private var sourceLang: String? = null
    private var targetLang: String? = null
    private var noOfAnswers: Int? = null
    private var noOfAnswersString: String? = null

    var answerButton: Button? = null
    var transTextField: EditText? = null
    var originalTextField: TextView? = null
    var sourceLangTV: TextView? = null
    var targetLangTV: TextView? = null
    var noOfAnsersTV: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val args = CreateAnswerFragmentArgs.fromBundle(it)
            requestId = args.requestId
        }
        populateProperties()

    }

    private fun populateProperties() {
        val request = requestRepo.findById(requestId!!)
        //Toast.makeText(context, "$request", Toast.LENGTH_LONG).show()
        origText = request!!.textToTranslate
        noOfAnswers = request.noOfAnswers
        noOfAnswersString = context!!.getString(R.string.answered_no_of_answers, noOfAnswers.toString())
        sourceLang = context!!.getString(R.string.answered_original_textview,request.languageOrigin)
        targetLang = context!!.getString(R.string.answered_translated_textview,request.languageTarget)
    }

    private fun assignViews(view:View){
        transTextField = view.findViewById(R.id.answered_translated_text)
        originalTextField = view.findViewById(R.id.answered_original_text)
        sourceLangTV = view.findViewById(R.id.answered_original_textview)
        targetLangTV = view.findViewById(R.id.answered_translated_textview)
        noOfAnsersTV = view.findViewById(R.id.answered_no_of_answers)
        answerButton = view.findViewById(R.id.answer_button)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_answersdetail, container, false)
        activity?.title= fragmentTitle
        assignViews(view)

        sourceLangTV?.text = sourceLang
        targetLangTV?.text = targetLang
        originalTextField?.text = origText
        noOfAnsersTV?.text = noOfAnswersString
        transTextField?.text?.clear()

        answerButton!!.setOnClickListener{
            if (transTextField?.text.isNullOrBlank() ){
                Toast.makeText(context, "Please write a translation", Toast.LENGTH_LONG).show()
            }
            else {
                val translation: String = transTextField?.text.toString()
                Toast.makeText(context, "Translation send: $translation", Toast.LENGTH_LONG).show()
                saveAnswer(translation)
                noOfAnswers?.plus(1)
                refreshFragment()
            }
        }

        return view
    }
    private fun refreshFragment(){
        transTextField?.text?.clear()
        noOfAnswersString = context!!.getString(R.string.answered_no_of_answers, noOfAnswers.toString())
        noOfAnsersTV?.text = noOfAnswersString
    }

    private fun saveAnswer(answerString: String){
        val answer: CreateAnswer = CreateAnswer(answerString, requestId!!)
        requestRepo.addAnswer(answer)
    }


}
