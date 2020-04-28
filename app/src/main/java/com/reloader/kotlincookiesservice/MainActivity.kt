package com.reloader.kotlincookiesservice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val endPoint = getConfiguration().create(APIService::class.java)
        val responseBodyCall = endPoint.postRegistrarUsuario("a@a.com", "123456")
        responseBodyCall.enqueue(object : Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                val informacion: ResponseBody? = response.body()

                if (response.isSuccessful) {
                    try {
                        val cookie = response.headers().get("Set-Cookie")

                        Log.v("cookieData", cookie.toString())
                        Log.v("jsonresponse", informacion.toString())


                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("infoResponseErrorPost", t.message)
            }
        })
    }
}
