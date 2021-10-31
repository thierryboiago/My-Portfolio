package br.com.dio.myportfolio.presentation.di

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.myportfolio.data.model.Repo
import br.com.dio.myportfolio.databinding.ItemRepositoryBinding
import com.bumptech.glide.Glide

class RepoListAdapter : ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {
    inner class ViewHolder(private val binding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Repo) {
            binding.txtNameRepository.text = item.name
            binding.txtDescriptionRepository.text = item.description
            binding.txtLanguageRepository.text = item.language
            binding.cpStarRepository.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL)
                .into(binding.imgOwner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepositoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem.id == newItem.id

}
