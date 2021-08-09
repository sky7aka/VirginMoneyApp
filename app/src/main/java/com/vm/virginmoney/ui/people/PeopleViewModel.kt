package com.vm.virginmoney.ui.people

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vm.virginmoney.data.repository.Repository

class PeopleViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {
    val people = repository.getPeopleListData()
}