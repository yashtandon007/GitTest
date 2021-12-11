package com.tcs.testggit.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var data = MutableLiveData<Int>()
    var job:Job?=null
    init {
        data.postValue(1)
    }
    fun start(){

        job = viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
            while(true){
                delay(500)
                data.postValue(data.value!! + 1)
            }
        }

    }

}