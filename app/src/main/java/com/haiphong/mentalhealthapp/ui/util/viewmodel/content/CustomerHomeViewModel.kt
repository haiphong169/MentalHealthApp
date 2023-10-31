package com.haiphong.mentalhealthapp.ui.util.viewmodel.content

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.haiphong.mentalhealthapp.MyApplication
import com.haiphong.mentalhealthapp.ui.util.repositories.MoodRepository
import com.haiphong.mentalhealthapp.ui.util.repositories.MoodRepositoryImpl
import com.haiphong.mentalhealthapp.ui.util.repositories.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneId

class CustomerHomeViewModel(private val userPreferencesRepository: UserPreferencesRepository) :
    ViewModel() {
    private var _openDialog = MutableStateFlow(false)
    val openDialog = _openDialog.asStateFlow()

    private val moodRepository: MoodRepository = MoodRepositoryImpl()

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                CustomerHomeViewModel(application.userPreferencesRepository)
            }
        }
    }


    init {
        viewModelScope.launch {
            userPreferencesRepository.currentTime.collect { currentTime ->
                _openDialog.update {
                    LocalDateTime.now().atZone(ZoneId.of("Asia/Ho_Chi_Minh"))
                        .toEpochSecond() > currentTime
                }
            }
        }
    }

    private fun updateTime() {
        viewModelScope.launch {
            userPreferencesRepository.updateTime()
        }
    }

    fun closeDialog() {
        _openDialog.update {
            false
        }
        updateTime()

    }

    fun addMood(value: Int) {
        moodRepository.addMood(value)
        closeDialog()
    }

}