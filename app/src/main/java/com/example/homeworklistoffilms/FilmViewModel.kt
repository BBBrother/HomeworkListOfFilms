package com.example.homeworklistoffilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class FilmViewModel: ViewModel() {

    private val _progressBarLiveData = MutableLiveData<Boolean>()
    val progressBarLiveData: LiveData<Boolean> get() = _progressBarLiveData

    private val _filmLiveData = MutableLiveData<List<MovieData>>()
    val filmLiveData: LiveData<List<MovieData>> get() = _filmLiveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val exceptionHolder = CoroutineExceptionHandler{_,thorwable ->
        when (thorwable){
            is SocketTimeoutException -> _errorLiveData.value = R.string.connection_error
            else -> _errorLiveData.value = R.string.unknown_error
        }
    }

    fun getFilm(){
        _progressBarLiveData.value = true
        viewModelScope.launch {
            val film = Server.getMovie()
            _filmLiveData.value = film
        }
        _progressBarLiveData.value = false
    }
}