package dk.enmango.ordsomegram.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.RequestRepository

class RequestListViewModel(val requestRepository: RequestRepository) : ViewModel() {

    val requestList: LiveData<MutableList<Request>> = requestRepository.requestList as LiveData<MutableList<Request>>
}