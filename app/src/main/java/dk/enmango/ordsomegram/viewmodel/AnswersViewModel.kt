package dk.enmango.ordsomegram.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.RequestCallback
import dk.enmango.ordsomegram.services.RequestRepository
import org.koin.core.KoinComponent
import org.koin.core.inject


class AnswersViewModel(app: Application) : AndroidViewModel(app), KoinComponent, RequestCallback {
    var fragmentTitle = MutableLiveData<String>()
    val requestRepository: RequestRepository by inject()
    val requestList = MutableLiveData<MutableList<Request>>()

    init{
        Log.i("RequestListViewModel", "View model created")
        requestRepository.getRequests(this)
        fragmentTitle.value = app.getString(R.string.answers_fragment_title)
    }

    override fun onSuccessRequestList(response: MutableList<Request>) {
        requestList.postValue(response)
    }
}