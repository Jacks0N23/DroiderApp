package io.justdev.droiderapp.api

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jackson on 20/12/2016.
 */
interface DroiderApi {

    @GET("/wp-content/themes/droider/feed.php")
    fun getFeed(@Query("category")
                category: String,
                @Query("slug")
                slug: String,
                @Query("count")
                count: Int,
                @Query("offset")
                offset: Int): Observable<Response<FeedModel>>

    @GET("/wp-content/themes/droider/feed.php?category=0&slug=promotion")
    fun getPopular(): Observable<Response<FeedModel>>
}

data class FeedModel(@SerializedName("has_more")
                     val hasMore: Boolean? = null, val posts: ArrayList<Post>)