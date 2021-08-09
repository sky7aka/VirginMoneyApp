package com.vm.virginmoney.data.model

import android.widget.ImageView
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

class People {

    @SerializedName("avatar")
    var avatar: String?= null

    @SerializedName("phone")
    var phone: String?= null

    @SerializedName("firstName")
    var firstName: String?= null

    @SerializedName("id")
    var id: String?= null

    @SerializedName("longitude")
    var longitude: Double?= null

    @SerializedName("latitude")
    var latitude: Double?= null

    @SerializedName("favouriteColor")
    var favouriteColor: String?= null

    @SerializedName("email")
    var email: String?= null

    @SerializedName("jobTitle")
    var jobTitle: String?= null

    @SerializedName("createdAt")
    var createdAt: String?= null

    @SerializedName("lastName")
    var lastName: String?= null

}