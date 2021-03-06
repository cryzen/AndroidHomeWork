package com.example.androidhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverViewModel : ViewModel() {

   private val messageMutableLiveData = MutableLiveData<String>()

    val messageLiveData: LiveData<String>
        get() = messageMutableLiveData

    fun setMessage(text: String) {
        messageMutableLiveData.value = text
    }
}