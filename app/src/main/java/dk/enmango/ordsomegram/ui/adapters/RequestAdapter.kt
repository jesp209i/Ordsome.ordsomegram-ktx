package dk.enmango.ordsomegram.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.ui.interfaces.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_my_request_item.view.*

class RequestAdapter(
    private val mValues: ArrayList<Request>,
    private val mListener: OnListFragmentInteractionListener?,
    private val appContext: Context
        ) : RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Request
            mListener?.onListFragmentInteraction(item, this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_my_request_item, parent, false)
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
    fun refreshList(requestList: ArrayList<Request>) {
        mValues.clear()
        mValues.addAll(requestList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemAnswers = view.no_of_answers
        val itemOriginalText = view.original_text
        val itemSourceToTargetLanguage = view.source_to_target_language_textview
        override fun toString(): String {
            return super.toString() + " '" + itemOriginalText + "'"
        }

    }
}