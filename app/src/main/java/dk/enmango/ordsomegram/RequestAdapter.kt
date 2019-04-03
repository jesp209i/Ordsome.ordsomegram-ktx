package dk.enmango.ordsomegram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.model.Request
import kotlinx.android.synthetic.main.fragment_requestitem.view.*

class RequestAdapter(
        private val mValues: ArrayList<Request>,
        private val mListener: RequestListFragment.OnListFragmentInteractionListener?
        ) : RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Request
            mListener?.onListFragmentInteraction(item)}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_requestitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.itemAnswers.text = "${mValues.get(position).answers.size}."
        holder.itemOriginalText.text = mValues.get(position).textToTranslate
        holder.itemSourceLanguage.text = mValues.get(position).languageOrigin
        holder.itemTargetLanguage.text = mValues.get(position).languageTarget

        with(holder.itemView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemAnswers = view.no_of_answers
        val itemOriginalText = view.original_text
        val itemSourceLanguage = view.source_language_textview
        val itemTargetLanguage = view.target_language_textview
        override fun toString(): String {
            return super.toString() + " '" + itemOriginalText + "'"
        }

    }
}