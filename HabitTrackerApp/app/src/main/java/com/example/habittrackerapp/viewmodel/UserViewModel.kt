package com.example.habittrackerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittrackerapp.model.User
import com.example.habittrackerapp.network.RetrofitClient
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException

class UserViewModel : ViewModel() {

    val usersLiveData = MutableLiveData<List<User>>()
    val errorLiveData = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun fetchUser() {
        viewModelScope.launch {
            try {
                val users = RetrofitClient.apiService.getUsers()
                usersLiveData.postValue(users)

            } catch (e: HttpException) {
                // HTTP exception (e.g., 404, 500)
                errorLiveData.postValue("HTTP Server error: ${e.message}, ${e.code()}")
            } catch (e: SocketTimeoutException) {
                // Timeout exception
                errorLiveData.postValue("Request time out. Please try again")
            } catch (e: IOException) {
                // Network error (No internet, etc.)
                errorLiveData.postValue("Network error check your connection")
            } catch (e: Exception) {
                // Any other error
                errorLiveData.postValue("Unknown error occur: ${e.message} ")
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}