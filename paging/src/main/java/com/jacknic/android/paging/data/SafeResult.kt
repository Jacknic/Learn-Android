package com.jacknic.android.paging.data

/**
 * 请求结果密封类
 */
sealed class SafeResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : SafeResult<T>()
    data class Error(val exception: Exception) : SafeResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }

    /**
     * 成功回调
     * [action] 后续逻辑
     */
    fun onSuccess(action: (value: T) -> Unit): SafeResult<T> {
        if (this is Success) {
            action(data)
        }
        return this
    }

    /**
     * 出错回调
     * [action] 后续逻辑
     */
    fun onError(action: (exception: Throwable) -> Unit): SafeResult<T> {
        if (this is Error) {
            action(exception)
        }
        return this
    }
}
