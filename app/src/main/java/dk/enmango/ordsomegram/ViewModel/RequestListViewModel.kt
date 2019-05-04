package dk.enmango.ordsomegram.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.enmango.ordsomegram.model.Request

class RequestListViewModel : ViewModel() {
    val requestList: MutableLiveData<MutableList<Request>> by lazy {
        MutableLiveData<MutableList<Request>>()
    }
}