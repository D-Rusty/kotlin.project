package com.example.onepice.lession1.data

import com.example.onepice.lession1.BuildConfig
import com.example.onepice.lession1.vo.EosAccountInfoVo
import com.example.onepice.lession1.vo.EosTransferDetailsVo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/12  4:51 PM
 */
object RetrofitManager {

    private var mRetrofit: Retrofit

    init {
        mRetrofit = initRetrofit(BuildConfig.BASE_URL)
    }


    /**
     * 初始化Retrofit
     */
    private fun initRetrofit(base_url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initOkHttpClient())
            .build()
    }

    /**
     * 初始化OkHttpClient
     */
    private fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(
                        if (BuildConfig.DEBUG)
                            HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    )
            ).build()
    }

    /**
     * 查询交易详情
     */
    fun getContractTrxInfo(accountName: String, page: Int, callBack: CallBack<EosTransferDetailsVo>) {
        RxUtils.runRxLambda(
            mRetrofit.create(IApiServer::class.java).getContractTrxInfo(accountName, page), callBack
        )
    }

    /**
     * 查询账号详情
     */
    fun getEosAccountInfo(accountName: String, callBack: CallBack<EosAccountInfoVo>) {
        RxUtils.runRxLambda(
            mRetrofit.create(IApiServer::class.java).getAccountInfo(accountName), callBack
        )
    }


}