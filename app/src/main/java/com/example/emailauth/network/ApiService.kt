package com.example.emailauth.network

import com.example.emailauth.domain.Login
import com.example.emailauth.domain.LoginModel
import com.example.emailauth.domain.ResponseClass
import okhttp3.MultipartBody
import retrofit2.http.*

interface ApiService {

    @POST("/register")
    suspend fun register(
        // if you are sending each value in isolation, use field to specify what part of the form this value holds
        @Field("email") email: String,
        @Field("password") password: String
    ): ResponseClass<LoginModel>

    @POST("/login")
    // fi you are sending an object, use @field
    suspend fun login(@Body login: Login): Login


    // @path is the specific target path
//    @DELETE("client/{clientId}")
//    suspend fun deleteClient(@Path("clientId") clientId: Int): GenericResponseClass<Client>


    // @multipath uploads media files
//    /*Upload Profile Picture*/
//    @Multipart
//    @POST("upload")
//    suspend fun uploadImage(@Part image: MultipartBody.Part): GenericResponseClass<UserProfileImage>

/*
    @GET("download")
    suspend fun getUploadedImage(): GenericResponseClass<UserProfileImage>
*/

//    /* Verify auth token */
//    @GET("confirm")
//    suspend fun verifyAuthToken(
//        @Query("token") token: String
//    ): GenericResponseClass<String>

//    PUT vs PATCH
//    PATCH is used to update an existing entity with new information.
//    You can’t patch an entity that doesn’t exist.
//
//    PUT is used to set an entity’s information completely. PUTting is
//    similar to POSTing, except that it will overwrite the entity
//    if already exists or create it otherwise.

}