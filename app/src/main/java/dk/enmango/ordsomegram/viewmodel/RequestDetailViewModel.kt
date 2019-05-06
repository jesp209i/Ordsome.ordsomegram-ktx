package dk.enmango.ordsomegram.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dk.enmango.ordsomegram.R
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.Interfaces.AnswerCallback
import dk.enmango.ordsomegram.services.RequestRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class RequestDetailViewModel(val app: Application) : AndroidViewModel(app), KoinComponent, AnswerCallback {
    val requestRepo: RequestRepository by inject()
    val fragmentTitle= MutableLiveData<String>()
    val sourceLanguage = MutableLiveData<String>()
    val targetLanguage = MutableLiveData<String>()
    val originalRequestText = MutableLiveData<String>()
    val answerList = MutableLiveData<MutableList<Answer>>()

    init {
        Log.i("RequestDetailViewModel", "View model created")
        fragmentTitle.value = app.getString(R.string.request_detail)
    }

    override fun onSuccessAnswerList(requestId: Int, response: MutableList<Answer>) {
        answerList.postValue(response)
    }
    fun getRequestDetails(requestId: Int){
        val request = requestRepo.findById(requestId)
        request?.let {
            sourceLanguage.value = app.getString(R.string.answered_original_textview,it.languageOrigin)
            targetLanguage.value = app.getString(R.string.answered_translated_textview,it.languageTarget)
            originalRequestText.value = it.textToTranslate
        }
        requestRepo.getAnswers(requestId, this)
    }
}