package com.example.onepice.lession1.domain

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/9  3:20 PM
 */
interface Command<T> {
    fun execute(): T
}