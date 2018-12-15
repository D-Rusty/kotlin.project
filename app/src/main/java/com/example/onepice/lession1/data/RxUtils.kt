package com.example.onepice.lession1.data

import android.util.Log
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/15  10:32 PM
 */
object RxUtils {

    fun <T> runRx(observable: Observable<T>, subscriber: Subscriber<T>): Subscription =
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)


    fun <T> runRxLambda(
        observable: Observable<T>,
        callBack: CallBack<T>,
        completed: () -> Unit = { Log.e("completed", "completed") }
    ) {
        runRx(observable, object : Subscriber<T>() {
            override fun onNext(t: T) {
                callBack.onSuccess(t)
            }

            override fun onCompleted() {
                completed
            }

            override fun onError(e: Throwable?) {
                callBack.onFail(e!!)
            }

        })
    }


}