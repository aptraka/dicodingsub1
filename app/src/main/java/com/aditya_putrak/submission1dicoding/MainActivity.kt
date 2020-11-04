package com.aditya_putrak.submission1dicoding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<UserItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listDataRV = findViewById<RecyclerView>(R.id.rv_list)
        initData()

        listDataRV.layoutManager = LinearLayoutManager(this)
        listDataRV.adapter = RecyclerViewAdapter(this, items) {

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA_USER, it)
            startActivity(intent)
        }
    }

    @SuppressLint("Recycle")
    private fun initData() {
        val name = resources.getStringArray(R.array.name)
        val username = resources.getStringArray(R.array.username)
        val location = resources.getStringArray(R.array.location)
        val avatar = resources.obtainTypedArray(R.array.avatar)
        val company = resources.getStringArray(R.array.company)
        val repos = resources.getStringArray(R.array.repository)
        val follower = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)

        items.clear()

        for (i in name.indices) {
            items.add(
                UserItem(
                    name[i],
                    username[i],
                    location[i],
                    avatar.getResourceId(i, 0),
                    company[i],
                    repos[i],
                    follower[i],
                    following[i]
                )
            )
        }
    }
}
