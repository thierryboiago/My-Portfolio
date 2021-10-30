package br.com.dio.myportfolio.data.services

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    suspend fun listRepositories(@Path("user") user: String): List<Repository>
}