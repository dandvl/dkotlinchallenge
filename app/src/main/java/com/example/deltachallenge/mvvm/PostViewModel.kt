package com.example.deltachallenge.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deltachallenge.data.Post
import com.example.deltachallenge.repository.Repository
import kotlinx.coroutines.launch

class PostViewModel(var repository: Repository) : ViewModel() {

    var postsLD = MutableLiveData<List<Post>>()

    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
        postsLD.value = repository.all()
    }

}