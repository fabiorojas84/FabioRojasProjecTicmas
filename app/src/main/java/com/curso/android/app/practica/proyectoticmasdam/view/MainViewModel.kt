package com.curso.android.app.practica.proyectoticmasdam.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.proyectoticmasdam.R
import com.curso.android.app.practica.proyectoticmasdam.model.Compare
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val comparator: LiveData<Compare> get() = _comparator

    private var _comparator = MutableLiveData<Compare>()
    private val regex = Regex("[\$\\u00A9\\u00AE\\u2117\\u20AC\\u00A3\\u00A5\\u00A2\\u20B9\\u20A8\\u20B1\\u20A9\\u0E3F\\u20AB\\u20AA\\u2122\\u2120@#%&*?¡¿ºª\\u2014+_=<>\\p{Punct}{}()^~`´¨|/.,:;\"'!]+")
    val textResponse: LiveData<String> get() = _textResponse
    private var _textResponse = MutableLiveData<String>()
    var input1:MutableLiveData<String> = MutableLiveData()
    var input2:MutableLiveData<String> = MutableLiveData()


   fun verifyChain(){
       val option1 = caseNullOrBlank()
       val option2 = caseCharacters()
       if(option1 && option2 ){
           val input1 = input1.value.toString().trim()
           val input2 = input2.value.toString().trim()
           updateComparator(input1,input2)
       }
    }

    private fun updateComparator(input1:String,input2:String){
        viewModelScope.launch {
            _comparator.value = Compare(input1,input2)
        }
    }

    fun comparatorChain(){
        val input1:String = comparator.value?.input1.toString()
        val input2:String = comparator.value?.input2.toString()
        compareStr(input1,input2)
    }
    private fun caseNullOrBlank():Boolean{
        if (input1.value.isNullOrBlank() || input2.value.isNullOrBlank()){
            println(input1.value)
            _textResponse.value = getApplication<Application>().getString(R.string.string_vacio)
            return false
        }
        return true
    }
    private fun caseCharacters():Boolean{
        if (input1.value.toString().contains(regex) || input2.value.toString().contains(regex)){
            _textResponse.value = getApplication<Application>().getString(R.string.string_especial)
            return false
        }
        return true
    }
    private fun compareStr(input1: String,input2: String){
        val equals = input1.equals(input2, ignoreCase = true)
        if(equals){
            _textResponse.value = getApplication<Application>().getString(R.string.string_iguales)
        }else{
            _textResponse.value = getApplication<Application>().getString(R.string.string_distintos)
        }
    }
}