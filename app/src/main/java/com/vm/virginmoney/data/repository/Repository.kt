package com.vm.virginmoney.data.repository

import com.vm.virginmoney.data.remote.ApiData
import com.vm.virginmoney.data.service.callGetService
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteData: ApiData
) {

    fun getRoomListData() = callGetService(
        networkCall = { remoteData.getRoomListData() }
    )

    fun getPeopleListData() = callGetService(
        networkCall = { remoteData.getPeopleListData() }
    )
}