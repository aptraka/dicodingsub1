package com.aditya_putrak.submission1dicoding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserItem(
    val name: String?,
    val username: String?,
    val location: String?,
    val avatar: Int?,
    val company: String?,
    val repo: String?,
    val follower: String?,
    val following: String?
) : Parcelable