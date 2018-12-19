package com.example.onepice.lession1

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.example.onepice.lession1.data.CallBack
import com.example.onepice.lession1.vo.EosTransferDetailsVo
import com.example.onepice.lession1.data.RetrofitManager.getContractTrxInfo
import com.example.onepice.lession1.data.RetrofitManager.getEosAccountInfo
import com.example.onepice.lession1.vo.EosAccountInfoVo
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_eos_account.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isValidEosAccountName(s.toString())) {
                    requestNetWork(s.toString())
                }
            }

        })


    }

    /**
     * 校验有效eos账号名
     */
    fun isValidEosAccountName(eosAccountName: String): Boolean {
        val pattern = Pattern.compile("^[1-5a-z]{12,12}$")
        val matcher = pattern.matcher(eosAccountName)
        return matcher.matches()
    }

    @SuppressLint("CheckResult")
            /**
             * 请求网络
             */
    fun requestNetWork(eosAccountName: String) {

//        //获取该账户详情
//        getContractTrxInfo(eosAccountName, 1, object :
//            CallBack<EosTransferDetailsVo> {
//            override fun onSuccess(data: EosTransferDetailsVo) {
//                textviewx.text = data.trace_list.get(0).sender
//            }
//
//            override fun onFail(throwable: Throwable) {
//
//            }
//
//        })


        getEosAccountInfo(eosAccountName, object : CallBack<EosAccountInfoVo> {

            override fun onFail(throwable: Throwable) {

            }

            override fun onSuccess(data: EosAccountInfoVo) {
                textviewx.text = data.create_timestamp
            }

        })

    }


}

