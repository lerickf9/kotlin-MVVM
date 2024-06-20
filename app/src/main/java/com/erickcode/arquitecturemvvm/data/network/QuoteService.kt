package com.erickcode.arquitecturemvvm.data.network

import com.erickcode.arquitecturemvvm.core.RetrofitHelper
import com.erickcode.arquitecturemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//import retrofit2.Response

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}