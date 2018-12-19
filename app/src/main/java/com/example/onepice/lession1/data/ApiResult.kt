package com.example.onepice.lession1.data

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/15  10:31 PM
 */
class ApiResult<T>(codeStr: Int, msg: String, t: T) {


    val errmsg: String = msg
    val errno: Int = codeStr
    val data: T = t

    fun isResultOk(): Boolean {
        return 0 == errno
    }
}