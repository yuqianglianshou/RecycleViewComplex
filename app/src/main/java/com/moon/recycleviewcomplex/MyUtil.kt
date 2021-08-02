package com.moon.recycleviewcomplex

import android.util.Log

/**
 *
 *@author : lq
 *@date   : 2021/7/30
 *@desc   :
 *
 */
class MyUtil {

    /**
     * 测试数据
     */
    fun getTestData(): ArrayList<DataBean> {
        val list = ArrayList<DataBean>()

        //1
        list.add(DataBean(TYPE_title, 1))
        list.add(DataBean(TYPE_data, 1, "张三", "男", "汉", "1992-06-01", "法外狂徒"))
        list.add(DataBean(TYPE_data, 1, "张四", "男", "汉", "1992-06-01", "法外狂徒"))
        list.add(DataBean(TYPE_data, 1, "张五", "男", "汉", "1992-06-01", "法外狂徒"))
        list.add(DataBean(TYPE_add, 1))

        //2
        list.add(DataBean(TYPE_title, 2))
        list.add(DataBean(TYPE_data, 2, "李四", "男", "汉", "1992-06-01", "人间正道"))
        list.add(DataBean(TYPE_data, 2, "李五", "男", "汉", "1992-06-01", "人间正道"))
        list.add(DataBean(TYPE_data, 2, "李六", "男", "汉", "1992-06-01", "人间正道"))
        list.add(DataBean(TYPE_add, 2))

        //3
        list.add(DataBean(TYPE_title, 3))
        list.add(DataBean(TYPE_data, 3, "王五", "男", "汉", "1992-06-01", "隔壁大叔"))
        list.add(DataBean(TYPE_data, 3, "王六", "男", "汉", "1992-06-01", "隔壁大叔"))
        list.add(DataBean(TYPE_data, 3, "王七", "男", "汉", "1992-06-01", "隔壁大叔"))
        list.add(DataBean(TYPE_add, 3))

        return list
    }

    /**
     * 添加组数据
     */
    fun addGroupData(list: ArrayList<DataBean>) {
        var j = 1
        if (list.size != 0) {
            j = list.last().title + 1
        }
        list.add(DataBean(TYPE_title, j))
        for (i in 1..3) {
            list.add(DataBean(TYPE_data, j))
        }
        list.add(DataBean(TYPE_add, j))

    }

    /**
     * 添加一条数据
     */
    fun addSingleData(list: ArrayList<DataBean>, position: Int) {

        var bean = list.get(position).copy()
        bean.type = TYPE_data
        Log.i("lq", "添加数据 == " + bean.toString())
        list.add(position, bean)

    }

}