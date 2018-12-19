package com.example.onepice.lession1.data

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/19  4:38 PM
 */
open class RxBaseThrowAble(code: Int, message: String) : Exception() {
    val mCode: Int = code
    val mMessage: String = message
}