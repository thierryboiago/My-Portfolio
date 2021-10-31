package br.com.dio.myportfolio.domain

import br.com.dio.myportfolio.core.UseCase
import br.com.dio.myportfolio.data.model.Repo
import br.com.dio.myportfolio.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
    ) : UseCase<String, List<Repo>>() {
    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}