package com.moon.recycleviewcomplex

import android.widget.TextView
import com.chad.library.adapter.base.BaseDelegateMultiAdapter
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.moon.recycleviewmul.R

/**
 *
 *@author : lq
 *@date   : 2021/7/30
 *@desc   :
 *
 */
open class MyAdapter : BaseDelegateMultiAdapter<DataBean, BaseViewHolder> {

    constructor() {
        setMultiTypeDelegate(object : BaseMultiTypeDelegate<DataBean>() {
            override fun getItemType(data: List<DataBean>, position: Int): Int {
                return data.get(position).type
            }
        })

        getMultiTypeDelegate()
            ?.addItemType(TYPE_title, R.layout.item_list_title)
            ?.addItemType(TYPE_data, R.layout.item_list_data)
            ?.addItemType(TYPE_add, R.layout.item_list_add)
    }


    override fun convert(holder: BaseViewHolder, item: DataBean) {

        when (item.type) {
            TYPE_title -> {
                holder.getView<TextView>(R.id.tv_title).text = "第 " + item.title + " 组"
            }
            TYPE_data -> {
                holder.getView<TextView>(R.id.tv1).text = item.tv1.toString()
                holder.getView<TextView>(R.id.tv2).text = item.tv2.toString()
                holder.getView<TextView>(R.id.tv3).text = item.tv3.toString()
                holder.getView<TextView>(R.id.tv4).text = item.tv4.toString()
                holder.getView<TextView>(R.id.tv5).text = item.tv5.toString()
            }
            TYPE_add -> {

            }
        }


    }
}
