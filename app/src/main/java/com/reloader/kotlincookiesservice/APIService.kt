package com.reloader.kotlincookiesservice

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {

    @FormUrlEncoded
    @POST("users/login")
    fun postRegistrarUsuario(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>

}