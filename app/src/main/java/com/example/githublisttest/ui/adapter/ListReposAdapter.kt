package com.example.githublisttest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githublisttest.R
import com.example.githublisttest.core.BaseViewHolder
import com.example.githublisttest.databinding.ItemRepoGitBinding
import com.example.githublisttest.domain.models.RepoGit

class ListReposAdapter(
    private val context: Context,
    private val reposList: ArrayList<RepoGit>,
    private val itemClickListener: OnRepoClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnRepoClickListener {
        fun onRepoClick(repo: RepoGit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemRepoGitBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListReposViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is ListReposViewHolder -> holder.bind(reposList[position], position)
        }
    }

    override fun getItemCount(): Int = reposList.size

    inner class ListReposViewHolder(private val binding: ItemRepoGitBinding) :
        BaseViewHolder<RepoGit>(binding.root) {
        override fun bind(item: RepoGit, position: Int): Unit = with((binding)) {
            name.text = item.name
            fullName.text = item.fullName
            createDate.text = item.createdAt
            itemView.setOnClickListener { itemClickListener.onRepoClick(item) }
        }
    }
}