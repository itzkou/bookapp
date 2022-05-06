package com.example.bfn.util

import com.example.bfn.models.User
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface ApiService {

    @POST("login")
    fun login(@Body post: User): Call<JsonObject>
    @POST("users")
    fun register(@Body post: User): Call<JsonObject>
    @GET("allBooks")
    fun getBooksHome(): Call<JsonObject>

    @FormUrlEncoded
    @PATCH("updateuser")
    fun editProfile(@FieldMap params: HashMap<String?, String?>): Call<JsonObject>

    @Multipart
    @PUT("edit-profile-picture")
    fun editProfilePicture(@Part img : MultipartBody.Part, @Part("email") email:String): Call<JsonObject>

    @FormUrlEncoded
    @POST("getuser")
    fun getUserByToken(@FieldMap params: HashMap<String?, String?>): Call<JsonObject>

    @DELETE("one/{user_id}")
    fun deleteAccount(@Path("user_id") user_id:String): Call<JsonObject>

  /*  @FormUrlEncoded
    @POST("panier/get-my")
    fun getPanier(@FieldMap params: HashMap<String?, String?>): Call<JsonObject>

    @FormUrlEncoded
    @POST("panier/add-to-cart")
    fun addToCart(@FieldMap params: HashMap<String?, String?>): Call<JsonObject>
*/


}