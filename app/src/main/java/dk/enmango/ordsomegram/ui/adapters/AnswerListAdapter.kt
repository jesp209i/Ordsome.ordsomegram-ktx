package dk.enmango.ordsomegram.ui.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.ui.interfaces.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_my_request_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnAnswerListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class AnswerListAdapter(
    private val mValues: List<Request>,
    private val mListenerAnswer: OnListFragmentInteractionListener?,
    private val appContext: Context
) : RecyclerView.Adapter<AnswerListAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Request
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListenerAnswer?.onListFragmentInteraction(item,this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_my_request_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        val srcLanToTgtLan = appContext.getString(R.string.lang_to_lang,item.languageOrigin,item.languageTarget)
        holder.itemAnswers.text = item.noOfAnswers.toString()
        holder.itemOriginalText.text = item.textToTranslate
        holder.itemSourceToTargetLanguage.text = srcLanToTgtLan
        with(holder.itemView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemAnswers = view.no_of_answers
        val itemOriginalText = view.original_text
        val itemSourceToTargetLanguage = view.source_to_target_language_textview
        override fun toString(): String {
            return super.toString() + " '" + itemOriginalText + "'"

        }
    }
}
