package com.isilsubasi.roommvvmexample.utils

data class DataStatus<out T> (

    val status : Status,
    val data : T?=null,
    val message : String?=null,
    val isEmpty : Boolean?=false ){
    enum class Status{
        SUCCESS,ERROR
    }
    companion object{
        fun <T> success(data : T? , isEmpty : Boolean?) : DataStatus<T>{
            return DataStatus(Status.SUCCESS,data,isEmpty=isEmpty)
        }

        fun <T> error(error : String) : DataStatus<T>{
            return DataStatus(Status.ERROR, message = error)
        }


    }


}