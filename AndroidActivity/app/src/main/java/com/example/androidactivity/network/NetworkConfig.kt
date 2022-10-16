package com.example.androidactivity.network

import com.example.androidactivity.model.ResponseAddMahasiswa
import com.example.androidactivity.model.ResponseAddMahasiswaItem
import com.example.androidactivity.model.ResponseMahasiswaItem
import com.example.androidactivity.model.ResponseUsersItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class NetworkConfig {
    // set interceptor
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return  okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://kpsi.fti.ukdw.ac.id")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @GET("users")
    fun getUsers(): Call<List<ResponseUsersItem>>
    @POST("api/progmob/mhs/create")
    fun addMahasiswa(@Body req : ResponseAddMahasiswaItem): Call<ResponseAddMahasiswa>

}


