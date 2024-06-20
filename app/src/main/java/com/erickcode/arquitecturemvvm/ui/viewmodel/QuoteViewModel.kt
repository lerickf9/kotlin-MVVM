package com.erickcode.arquitecturemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erickcode.arquitecturemvvm.data.model.QuoteModel
import com.erickcode.arquitecturemvvm.data.model.QuoteProvider
import com.erickcode.arquitecturemvvm.domain.GetQuotesUseCase
import com.erickcode.arquitecturemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()

    var getRandomQuoseUseCase = GetRandomQuoteUseCase()
    fun onCreate() {
        viewModelScope.launch {

            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }
    }
    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoseUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }

        isLoading.postValue(false)
    }


}