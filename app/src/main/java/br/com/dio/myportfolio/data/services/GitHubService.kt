package br.com.dio.myportfolio.data.services

import br.com.dio.myportfolio.data.model.Repo
import retrofit2.http.Path

interface GitHubService {
    suspend fun listRepositories(@Path("user") user: String): List<Repo>
}