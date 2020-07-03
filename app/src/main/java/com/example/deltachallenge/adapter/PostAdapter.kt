package com.example.deltachallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deltachallenge.data.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = PostViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.activity_list_item, parent, false))


    override fun getItemCount() = diff.currentList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.text1.text = diff.currentList[position].title
    }

    class PostViewHolder(parentView : View) : RecyclerView.ViewHolder(parentView){
        var text1 : TextView = parentView.findViewById(android.R.id.text1)
    }

    private val callback = object : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return true
        }

    }

    var diff = AsyncListDiffer(this, callback)
}