package com.example.habittrackerapp.activites

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittrackerapp.dto.UserDisplayData
import com.example.habittrackerapp.model.User
import com.example.habittrackerapp.model.UserResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class UserViewModel : ViewModel() {

    // LiveData to observe API result
    private val _userData = MutableLiveData<UserDisplayData>()
    val userData: LiveData<UserDisplayData> get() = _userData

    private val client = OkHttpClient()

    // Function to fetch data from API

    fun fetchRandomUser() {
        viewModelScope.launch(Dispatchers.IO) {
            // Network call and response handling
            val request = Request.Builder()
                .url("https://randomuser.me/api/")
                .build()

            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val responseData = response.body?.string()

                    responseData?.let {
                        try {
                            val userResponse = Gson().fromJson(it, UserResponse::class.java)
                            val user = userResponse.results.firstOrNull() // Use firstOrNull to avoid IndexOutOfBoundsException
                            user?.let { validUser ->
                                // Post the user data back to the main thread
                                _userData.postValue(UserDisplayData(validUser.name.first,validUser.gender))
                            } ?: run {
                                _userData.postValue(UserDisplayData("No name available", "N/A"))
                            }
                        } catch (e: Exception) {
                            Log.e("Parsing Error", "Error parsing JSON", e)
                            _userData.postValue(UserDisplayData("Error parsing data","N/A"))
                        }
                    } ?: run {
                        _userData.postValue(UserDisplayData("No data received from API","N/A"))

                    }
                } else {
                    _userData.postValue(UserDisplayData("Error: ${response.code}","NA"))
                }
            }
        }
    }



}