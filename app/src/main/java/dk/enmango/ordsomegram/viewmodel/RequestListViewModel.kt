package dk.enmango.ordsomegram.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.RequestRepository
import org.koin.android.ext.android.inject

class RequestListViewModel(val requestRepository: RequestRepository) : ViewModel() {
    val requestList: MutableLiveData<MutableList<Request>> by lazy {
        MutableLiveData<MutableList<Request>>().also {
            loadRequests()
        }
    }

    private fun loadRequests() {
        requestList.clear()
        requestList.addAll(requestRepository.getRequests(null));
    }
}