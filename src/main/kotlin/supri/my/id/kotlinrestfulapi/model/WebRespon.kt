package supri.my.id.kotlinrestfulapi.model

data class WebRespon<T> (
    val code :Int,
    val status:String,
    val data:T
    )