package com.ysn.coffeeshop.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

data class OrderViewModel(var order: MutableLiveData<Int> = MutableLiveData()) : ViewModel() {

    init {
        order.value = 0
    }

}
