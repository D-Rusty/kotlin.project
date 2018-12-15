package com.example.onepice.lession1.data

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/15  11:15 PM
 */
interface CallBack<T> {

    fun onSuccess(data: T)

    fun onFail(throwable: Throwable)
}