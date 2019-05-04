package dk.enmango.ordsomegram.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.RequestCallback
import dk.enmango.ordsomegram.services.RequestRepository
import dk.enmango.ordsomegram.ui.adapters.RecyclerViewAdapterWithListFragmentListener
import dk.enmango.ordsomegram.ui.interfaces.OnListFragmentInteractionListener
import org.koin.android.ext.android.inject


class MyRequestsFragment : Fragment(), RequestCallback{
    override fun onSuccessRequestList(response: MutableList<Request>) {
        requestList = requestRepo.requestList as ArrayList<Request>
        mAdapter?.refreshList(requestList)
    }
    private val fragmentTitle: String = "Svar på mine forespørgsler"
    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    val requestRepo: RequestRepository by inject()
    var requestList : ArrayList<Request> = arrayListOf<Request>()

    private var mAdapter: RecyclerViewAdapterWithListFragmentListener<MyRequestsFragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_my_requests, container, false)
        activity?.title = fragmentTitle
        requestRepo.getRequests(this)
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                mAdapter = RecyclerViewAdapterWithListFragmentListener(requestList, listener, context, MyRequestsFragment())
                adapter = mAdapter
            }
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        requestRepo.getRequests(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}
