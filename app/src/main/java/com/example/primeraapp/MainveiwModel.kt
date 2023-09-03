package com.example.primeraapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.primeraapp.Result

class MainveiwModel:ViewModel() {
    private val _result = MutableLiveData<Result>(Result(""))
    val result: LiveData<Result>
        get() = _result
    fun iguales(texto1:String, texto2:String){

        var resultado=Result("")
        if (texto1 == texto2) {
            resultado=Result("Son iguales")
            _result.value=resultado
        } else {
            resultado=Result("Son distintos")
            _result.value=resultado
        }

    }
}