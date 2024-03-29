package com.example.mayoufcv.screen.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mayoufcv.common.getLayoutInflater
import com.example.mayoufcv.data.Project
import com.example.mayoufcv.databinding.ItemProjectBinding

class ProjectsAdapter : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    private val projects = mutableListOf<Project>()

    fun setData(data: List<Project>) {
        projects.clear()
        projects.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = projects.size

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projects[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        parent.getLayoutInflater()?.let { ProjectViewHolder(ItemProjectBinding.inflate(it, parent, false)) }
            ?: throw IllegalStateException("View state is null")

    class ProjectViewHolder(private val itemProjectBinding: ItemProjectBinding) :
        RecyclerView.ViewHolder(itemProjectBinding.root) {

        fun bind(project: Project) {
            itemProjectBinding.project = project
            itemProjectBinding.executePendingBindings()
        }

    }
}