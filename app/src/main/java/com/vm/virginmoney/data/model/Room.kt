package com.vm.virginmoney.data.model

import com.google.gson.annotations.SerializedName

class Room {
    @SerializedName("id")
    var id: String?= null

    @SerializedName("name")
    var name: String?= null

    @SerializedName("max_occupancy")
    var maxOccupancy: Int?= null

    @SerializedName("is_occupied")
    var isOccupied: Boolean?= null

    @SerializedName("createdAt")
    var createdAt: String?= null
}