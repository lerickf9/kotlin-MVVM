package com.erickcode.arquitecturemvvm.domain

import com.erickcode.arquitecturemvvm.data.QuoteRepository
import com.erickcode.arquitecturemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}