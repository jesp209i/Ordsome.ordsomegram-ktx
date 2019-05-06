package dk.enmango.ordsomegram.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.viewmodel.RequestListViewModel
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.ui.adapters.RecyclerViewAdapterWithListFragmentListener
import dk.enmango.ordsomegram.ui.interfaces.OnListFragmentInteractionListener
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyRequestsFragment : Fragment(){
    private var requestListVM: RequestListViewModel? = null
    private var listener: OnListFragmentInteractionListener? = null
    private val requestList : ArrayList<Request> = arrayListOf()

    private var mAdapter: RecyclerViewAdapterWithListFragmentListener<MyRequestsFragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle? ): View? {
        val recyclerView = inflater.inflate(R.layout.fragment_my_requests, container, false)
        if (recyclerView is RecyclerView) {
            with(recyclerView) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                mAdapter = RecyclerViewAdapterWithListFragmentListener(requestList, listener, activity!!.applicationContext, this@MyRequestsFragment)
                adapter = mAdapter
            }
        }
        initViewModel()
        return recyclerView
    }

    private fun initViewModel() {
        requestListVM = ViewModelProviders.of(this).get(RequestListViewModel::class.java)
        val listObserver: Observer<MutableList<Request>> = Observer{
            requestList.clear()
            requestList.addAll(it)
            mAdapter?.notifyDataSetChanged()
        }
        requestListVM?.fragmentTitle?.observe(this, Observer {
            activity?.title = it
        })
        requestListVM?.requestList?.observe(this,listObserver)
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
