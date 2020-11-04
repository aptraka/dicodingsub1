package com.aditya_putrak.submission1dicoding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapter(
    private val context: Context,
    private val itemUser: List<UserItem>,
    private val listener: (UserItem) -> Unit
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(itemUser[position], listener)
    }

    override fun getItemCount(): Int = itemUser.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tv_user)
        private val username = view.findViewById<TextView>(R.id.tv_username)
        private val location = view.findViewById<TextView>(R.id.tv_location)
        private val avatar = view.findViewById<CircleImageView>(R.id.civ_avatar)

        fun bindItem(userItem: UserItem, listener: (UserItem) -> Unit) {
            name.text = userItem.name
            username.text = userItem.username
            location.text = userItem.location
            userItem.avatar?.let { Glide.with(itemView.context).load(userItem.avatar).into(avatar) }
            itemView.setOnClickListener { listener(userItem) }
        }

    }

}