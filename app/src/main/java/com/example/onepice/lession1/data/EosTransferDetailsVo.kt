package com.example.onepice.lession1.data

/**
 * Created by onepice on 2018-12-14
 */
data class EosTransferDetailsVo(
    var trace_count: Int,
    var trace_list: List<TraceList>
) {
    data class TraceList(
        var trx_id: String,
        var timestamp: String,
        var receiver: String,
        var sender: String,
        var code: String,
        var quantity: String,
        var memo: String,
        var symbol: String,
        var status: String
    )
}