package test.platzi.com.raian.com.org.simpleplatzi.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import test.platzi.com.raian.com.org.simpleplatzi.model.GitHubResult
import test.platzi.com.raian.com.org.simpleplatzi.model.ResultAuthorization

interface RestService{

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user")user:String) : Call<List<GitHubResult>>

    @GET("/basic")
    fun getAuthorizationResponse(@Header("Authorization") authorizationHeader:String):Call<ResultAuthorization>

}