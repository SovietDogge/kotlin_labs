package com.example.lab10

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/comments/1")
    suspend fun getComments() : Response<Comment>

    @POST("/comments/")
    suspend fun addComment(@Body comment: Comment) : Response<AddCommentResponse>
}