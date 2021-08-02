package com.moon.recycleviewcomplex

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.moon.recycleviewmul.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {

        val rv = findViewById<RecyclerView>(R.id.rv)

        val adapter = MyAdapter()

        adapter.addHeaderView(layoutInflater.inflate(R.layout.item_list_header_0, null))
        adapter.addHeaderView(layoutInflater.inflate(R.layout.item_list_header, null))

        adapter.addFooterView(layoutInflater.inflate(R.layout.item_list_footer_add_group, null))

        //item 单击事件
        adapter.setOnItemClickListener { adapter, view, position ->
            Log.i("lq", position.toString())
            var item = adapter.getItem(position) as DataBean
            when (item.type) {
                TYPE_title -> {
                    Toast.makeText(this, "第 " + item.title + "组", Toast.LENGTH_SHORT).show()
                }
                TYPE_data -> {
                    Toast.makeText(this, "" + item.tv1, Toast.LENGTH_SHORT).show()
                }
                TYPE_add -> {
                    Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show()
                    MyUtil().addSingleData(adapter.data as ArrayList<DataBean>, position)

                    adapter.notifyDataSetChanged()

                }
            }
        }

        //item 长按事件
        adapter.setOnItemLongClickListener { adapter, view, position ->
            Log.i("lq", "长按 " + position.toString())
            var item = adapter.getItem(position) as DataBean
            when (item.type) {
                TYPE_title -> {
                    Toast.makeText(this, "长按 第 " + item.title + "组", Toast.LENGTH_SHORT).show()
                }
                TYPE_data -> {
                    Toast.makeText(this, "长按  " + item.tv1, Toast.LENGTH_SHORT).show()
                }
                TYPE_add -> {
                    Toast.makeText(this, "长按  添加", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        rv.adapter = adapter

        adapter.addData(MyUtil().getTestData())

        adapter.footerLayout?.get(0)?.setOnClickListener {
            Log.i("lq", "添加组")
            MyUtil().addGroupData(adapter.data as ArrayList<DataBean>)
            adapter.notifyDataSetChanged()
        }
    }


}