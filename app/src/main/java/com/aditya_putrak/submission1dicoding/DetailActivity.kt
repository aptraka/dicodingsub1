package com.aditya_putrak.submission1dicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA_USER = "data_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val name = findViewById<TextView>(R.id.tv_name)
        val username = findViewById<TextView>(R.id.tv_username)
        val location = findViewById<TextView>(R.id.tv_location)
        val company = findViewById<TextView>(R.id.tv_company)
        val follower = findViewById<TextView>(R.id.tv_follower)
        val following = findViewById<TextView>(R.id.tv_following)
        val repo = findViewById<TextView>(R.id.tv_repo)
        val avatar = findViewById<CircleImageView>(R.id.civ_avatar)
        val dataUser = intent.getParcelableExtra(DATA_USER) as UserItem

        name.text = dataUser.name
        username.text = dataUser.username
        location.text = dataUser.location
        company.text = dataUser.company
        follower.text = dataUser.follower
        following.text = dataUser.following
        repo.text = dataUser.repo
        Glide.with(applicationContext).load(dataUser.avatar).into(avatar)

    }
}
