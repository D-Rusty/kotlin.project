package com.example.onepice.lession1

import android.widget.Toast

/**
 * 描    述：定义一个类
 * 作    者：fantianwen
 * 时    间：2018/12/9  10:42 AM
 */
class Person(name: String, surname: String) : Animal(name) {

    //默认构造方法 代替Android中的super
    init {

    }


    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun add2(x: Int, y: Int): Int = x + y

    /**
     * 提供默认变量
     */
    fun add3(x: Int, y: Int, c: Int = 3): Int = x + y + c

    //basic type 基本类型
    val i = 12  //An int
    val iHex = 0x0f //一个十六进制的Int类型
    val l = 3L //A Long
    val d = 3.5 // A Double
    val f = 3.5F //A Float

    val s = "Example"
    val c = s[2]//这是一个字符 'a'

//    for(ch in s){
//        print(ch)
//    }

    var name: String = ""
        get() = field.toUpperCase()
        set(value) {
            field = "Name: $value"
        }
}