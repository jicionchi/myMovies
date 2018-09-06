package com.ignaciocionchi.mymovies.service

import com.ignaciocionchi.mymovies.BuildConfig
import com.ignaciocionchi.mymovies.BuildConfig.CONNECT_TIMEOUT
import com.ignaciocionchi.mymovies.BuildConfig.READ_TIMEOUT
import com.ignaciocionchi.mymovies.MoviesApp
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object ServiceUtils {
    const val CACHE_CHILD = "http-cache"
    val movieApi: MovieApi = getRetrofitInstance().create(MovieApi::class.java)


    private fun getClient(): OkHttpClient {

        val cacheSize = 10 * 1024 * 1024 // 10 MB
        val httpCacheDirectory = File(MoviesApp.instance.getCacheDir(), CACHE_CHILD)
        val cache = Cache(httpCacheDirectory, cacheSize.toLong())


//        val networkCacheInterceptor = Interceptor { chain ->
//            val response = chain.proceed(chain.request())
//
//            var cacheControl = CacheControl.Builder()
//                    .maxAge(1, TimeUnit.MINUTES)
//                    .build()
//
//            response.newBuilder()
//                    .header("Cache-Control", cacheControl.toString())
//                    .build()
//        }
        return OkHttpClient.Builder()
                .cache(cache)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

//                .authenticator(CachingAuthenticatorDecorator(DigestAuthenticator(Credentials(username, password)), authCache))
//                .addInterceptor(AuthenticationCacheInterceptor(authCache))
//                .addNetworkInterceptor(networkCacheInterceptor)
                .build()
    }

    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .client(getClient())
                .build()
    }

//    fun getMovieApi(baseUrl: String): MovieApi {
//        if (movieApi == null) {
//            movieApi = getRetrofitInstance().create(MovieApi::class.java)
//        }
//        return movieApi!!
//    }

}