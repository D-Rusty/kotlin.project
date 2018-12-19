package com.example.onepice.lession1.data

import android.util.Log
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/15  10:32 PM
 */
object RxUtils {

    fun <T> runRx(observable: Observable<ApiResult<T>>, subscriber: Subscriber<T>): Subscription =
        observable
            .flatMap(object : Func1<ApiResult<T>, Observable<T>> {
                override fun call(t: ApiResult<T>?): Observable<T> {
                    if (t!!.isResultOk()) {
                        return Observable.just(t.data)
                    } else {
                        return Observable.error(RxBaseThrowAble(t.errno, t.errmsg))
                    }
                }

            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)


    fun <T> runRxLambda(
        observable: Observable<ApiResult<T>>,
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