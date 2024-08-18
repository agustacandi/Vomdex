package dev.agustacandi.learn.core.data.lib

sealed class RemoteResponse<out R> {
    data class Success<out T>(val data: T) : RemoteResponse<T>()
    data class Error(val errorMessage: String) : RemoteResponse<Nothing>()
    data object Loading : RemoteResponse<Nothing>()
    data object Empty : RemoteResponse<Nothing>()
}