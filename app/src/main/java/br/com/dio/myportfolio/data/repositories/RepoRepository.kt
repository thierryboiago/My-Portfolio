package br.com.dio.myportfolio.data.repositories

import br.com.dio.myportfolio.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user:String): Flow<List<Repo>>
}