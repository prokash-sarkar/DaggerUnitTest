package com.example.dagger.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger.data.DefaultDataRepository
import com.example.dagger.data.Result
import com.example.dagger.data.remote.model.Repo
import com.example.dagger.di.scopes.ActivityScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

// A unique instance of MainViewModel is provided in Components annotated with @ActivityScope
@ActivityScope
class MainViewModel @Inject constructor(
    private val repository: DefaultDataRepository
) : ViewModel() {

    private val TAG = "MainViewModel:"

    private val _items = MutableLiveData<List<Repo>>().apply { value = emptyList() }
    val items: LiveData<List<Repo>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    fun getSearchResponse(query: String) {
        _dataLoading.value = true

        viewModelScope.launch {
            repository.getSearchResponse(query, 1, 50).let { result ->
                when (result) {
                    is Result.Success -> {
                        Timber.d(TAG, "Request -> Success: $result")
                        _dataLoading.value = false
                        _items.value = result.data.items
                    }
                    is Result.Error -> {
                        Timber.d(TAG, "Request -> Error: ${result.exception.message}")
                        _dataLoading.value = false
                    }
                    Result.Loading -> {
                        Timber.d(TAG, "Request -> Loading...")
                        _dataLoading.value = true
                    }
                }
            }
        }
    }

}