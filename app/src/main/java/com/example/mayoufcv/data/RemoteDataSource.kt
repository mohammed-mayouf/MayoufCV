package com.example.mayoufcv.data

import com.example.mayoufcv.net.CVService
import io.reactivex.Maybe

class RemoteDataSource(private val cvService: CVService) : DataSource {
    override fun deleteAllProjects() {
        //NO-OP
    }

    override fun getAllProjects(isAscending: Boolean) = cvService.getCV()
        .map { projects -> projects.run { if(isAscending) sortedBy { it.projectId }
                else sortedByDescending { it.projectId } } }
        .flatMapMaybe { Maybe.just(it) }

    override fun addProject(project: Project) {
        //NO-OP
    }

}