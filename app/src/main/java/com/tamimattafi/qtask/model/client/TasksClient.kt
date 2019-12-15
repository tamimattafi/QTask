package com.tamimattafi.qtask.model.client

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Url

interface TasksClient {

    @GET
    fun execute(@Url url: String): Call<ResponseBody>


}