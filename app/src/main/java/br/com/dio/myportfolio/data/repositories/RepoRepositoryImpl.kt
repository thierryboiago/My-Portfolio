package br.com.dio.myportfolio.data.repositories

import br.com.dio.myportfolio.core.RemoteException
import br.com.dio.myportfolio.data.model.Repo
import br.com.dio.myportfolio.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService) : RepoRepository {
    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?:"Não foi possivel fazer a busca no momento!")
        }
    }
}