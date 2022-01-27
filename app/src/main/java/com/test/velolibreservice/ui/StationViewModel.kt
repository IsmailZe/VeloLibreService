package com.test.velolibreservice.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.velolibreservice.data.models.State
import com.test.velolibreservice.domain.StationsUseCase
import com.test.velolibreservice.data.models.Station
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
    private val stationsUseCase: StationsUseCase
) : ViewModel() {

    private val _stationsLiveData = MutableLiveData<State<List<Station>>>()
    val stationsLiveData: LiveData<State<List<Station>>> get() = _stationsLiveData

    suspend fun getStations() {
        viewModelScope.launch {
            try {
                _stationsLiveData.value = State.LoadingState
                val stations = stationsUseCase.getStations()
                _stationsLiveData.value = State.DataState(stations)
            } catch (e: Exception) {
                _stationsLiveData.value = State.ErrorState(e)
            }
        }
    }
}