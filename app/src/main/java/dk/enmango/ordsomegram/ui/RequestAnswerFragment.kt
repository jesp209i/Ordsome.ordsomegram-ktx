package dk.enmango.ordsomegram.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import dk.enmango.ordsomegram.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class RequestAnswerFragment : Fragment() {
var answerButton: Button? = null
    var transText: String? = null
    var transTextField: EditText? = null
    var noOfClicks: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_request_answer, container, false)
        transTextField = view.findViewById(R.id.answered_translated_text)
        val sourceLangTV = view.findViewById<TextView>(R.id.answered_original_textview)
        val targetLangTV = view.findViewById<TextView>(R.id.answered_translated_textview)
        val sourceTxt = context!!.getString(R.string.answered_original_textview, "Fransk")
        val targetTxt = context!!.getString(R.string.answered_translated_textview, "Dansk")
        sourceLangTV.text = sourceTxt
        targetLangTV.text = targetTxt
        transText = transTextField!!.text.toString()
        transTextField!!.text.clear()
        answerButton = view.findViewById(R.id.answer_button)
        answerButton!!.setOnClickListener{
            noOfClicks++
            if (noOfClicks%2 == 0) {
                transTextField!!.text.clear()
            }else{
                transTextField!!.setText(transText)
            }
        }

        return view
    }


}
