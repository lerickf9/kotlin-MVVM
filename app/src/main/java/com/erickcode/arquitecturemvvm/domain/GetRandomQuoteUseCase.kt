package com.erickcode.arquitecturemvvm.domain

import com.erickcode.arquitecturemvvm.data.model.QuoteModel
import com.erickcode.arquitecturemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {


    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }else{
            return null
        }
    }
}