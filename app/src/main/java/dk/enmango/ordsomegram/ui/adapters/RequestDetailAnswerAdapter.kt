package dk.enmango.ordsomegram.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.ui.interfaces.OnListClickListener
import dk.enmango.ordsomegram.ui.interfaces.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_request_detail_answer_list_item.view.*

class RequestDetailAnswerAdapter(
    private val mValues: ArrayList<Answer>,
    private val appContext: Context,
    private val mListenerAnswer: OnListClickListener?
        ) : RecyclerView.Adapter<RequestDetailAnswerAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Answer
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListenerAnswer?.onListClick(item)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(appContext).inflate(R.layout.fragment_request_detail_answer_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.itemAnswer.text = item.textTranslated
        when(item.isPreferred) {
            true -> { holder.preferredAnswerPic.setVisibility(View.VISIBLE)}
            false -> { holder.preferredAnswerPic.setVisibility(View.INVISIBLE) }
        }
        with(holder.itemView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemAnswer = view.answer_translated_text
        val preferredAnswerPic = view.preferredAnswerView
    }
}