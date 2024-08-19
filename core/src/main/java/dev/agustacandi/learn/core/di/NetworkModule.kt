package dev.agustacandi.learn.core.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.agustacandi.learn.core.BuildConfig
import dev.agustacandi.learn.core.data.credits.remote.network.CreditService
import dev.agustacandi.learn.core.data.lib.HeaderInterceptor
import dev.agustacandi.learn.core.data.movie.remote.network.MovieService
import dev.agustacandi.learn.core.utils.ConstVal
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// Logging Interceptor for debugging purposes (only run in debug mode)
private val loggingInterceptor = HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

// Moshi for JSON parsing
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

// Koin module for network dependencies
val networkModule = module {
    // Single instance of OkHttpClient
    single {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(getHeaderInterceptor())
            .build()
    }

    // Single instance of Retrofit
    single {
        Retrofit.Builder()
            .baseUrl(ConstVal.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(get())
            .build()
    }

    // Single instance of MovieService
    single {
        provideMovieService(get())
    }

    // Single instance of CastService
    single {
        provideCastService(get())
    }

}

private fun getHeaderInterceptor(): Interceptor {
    val headers = HashMap<String, String>()
    headers["Content-Type"] = "application/json"

    return HeaderInterceptor(headers)
}

// Function to provide MovieService instance
fun provideMovieService(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)

// Function to provide CastService instance
fun provideCastService(retrofit: Retrofit): CreditService = retrofit.create(CreditService::class.java)