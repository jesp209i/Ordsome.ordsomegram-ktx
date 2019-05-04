package dk.enmango.ordsomegram.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Answer
import kotlinx.android.synthetic.main.fragment_request_detail_answer_list_item.view.*

class RequestDetailAnswerAdapter(
    private val mValues: ArrayList<Answer>,
    private val appContext: Context
        ) : RecyclerView.Adapter<RequestDetailAnswerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(appContext).inflate(R.layout.fragment_request_detail_answer_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.itemAnswer.text = item.textTranslated
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemAnswer = view.answer_translated_text
    }
}