package com.erickcode.arquitecturemvvm.data

import com.erickcode.arquitecturemvvm.data.model.QuoteModel
import com.erickcode.arquitecturemvvm.data.model.QuoteProvider
import com.erickcode.arquitecturemvvm.data.network.QuoteService


class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}