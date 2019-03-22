package dk.enmango.ordsomegram

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RequestFragment : Fragment() {
    private val TAG = RequestFragment::class.java.simpleName
    private var sendButton: Button? = null
    private var textToTranslate: EditText? = null
    private var languageOrigin = "engelsk"
    private var languageTarget = "dansk"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        sendButton = view!!.findViewById(R.id.request_button)
        sendButton!!.setOnClickListener{
            Log.d(TAG, "onClickListener clicked! textToTranslate: $textToTranslate languageOrigin: $languageOrigin languageTarget: $languageTarget")
        }
        return inflater.inflate(R.layout.fragment_request, container, false)
    }

}
