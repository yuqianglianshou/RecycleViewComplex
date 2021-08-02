package com.moon.recycleviewcomplex

/**
 *
 *@author : lq
 *@date   : 2021/7/30
 *@desc   :
 *
 */
const val TYPE_title = 1
const val TYPE_data = 2
const val TYPE_add = 3

data class DataBean(
    var type: Int,
    var title: Int,//分组 1234
    var tv1: String = "",
    var tv2: String = "",
    var tv3: String = "",
    var tv4: String = "",
    var tv5: String = ""
)
