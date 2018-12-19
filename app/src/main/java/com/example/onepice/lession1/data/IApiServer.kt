package com.example.onepice.lession1.data

import com.example.onepice.lession1.vo.EosAccountInfoVo
import com.example.onepice.lession1.vo.EosTransferDetailsVo
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/14  4:19 PM
 */
interface IApiServer {
    /**
     * 获取交易详情
     */
    //curl -X GET 'https://api.eospark.com/api?module=contract&action=get_contract_trx_info&apikey=
    // a9564ebc3289b7a14551baf8ad5ec60a&account=liantongtt21&action_name=hi&page=1&size=20'

    @GET("/api")
    fun getContractTrxInfo(
        @Query("account") account: String,
        @Query("page") page: Int,
        @Query("module") module: String = "account",
        @Query("action") action: String = "get_account_related_trx_info",
        @Query("action_name") action_name: String = "hi",
        @Query("apikey") apikey: String = "bf212183176d599c77b91873f81c6b6f",
        @Query("size") size: Int = 10
    ): Observable<ApiResult<EosTransferDetailsVo>>


    /**
     * 查询eos账户详情
     */
    //curl -X GET 'https://api.eospark.com/api?module=account&action=get_account_info&
    //apikey=a9564ebc3289b7a14551baf8ad5ec60a&account=helloworldjs'
    @GET("/api")
    fun getAccountInfo(
        @Query("account") account: String,
        @Query("module") module: String = "account",
        @Query("action") action: String = "get_account_info",
        @Query("apikey") apikey: String = "bf212183176d599c77b91873f81c6b6f"
    ): Observable<ApiResult<EosAccountInfoVo>>

}

