package com.sachy.androidstructure.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sachy.androidstructure.network.NetworkConstant.Companion.BASE_URL
import com.sachy.androidstructure.network.NetworkConstant.Companion.PORT
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private var retrofit: Retrofit? = null
        private var okHttpClient: OkHttpClient? = null
        private var gsonFactory: GsonConverterFactory? = null

        private fun getGsonFactory(): GsonConverterFactory? {
            if (gsonFactory == null) {
                val gson: Gson = GsonBuilder().setLenient().create()
                gsonFactory = GsonConverterFactory.create(gson)
            }
            return gsonFactory
        }

        /**Declare OkHttp Client
         * -Print the api response
         * -Api response time outs*/
        private fun getOkHttpClient(): OkHttpClient? {
            if (okHttpClient == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()
            }
            return okHttpClient
        }

        /**This will provide the Retrofit client */
        fun getClient(): Retrofit? {
            //if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(String.format(PORT, BASE_URL))
                    .addConverterFactory(getGsonFactory())
                    .client(getOkHttpClient())
                    .build()
          //  }
            return retrofit
        }
    }


}