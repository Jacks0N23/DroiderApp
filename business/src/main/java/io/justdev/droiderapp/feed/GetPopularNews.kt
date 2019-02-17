package io.justdev.droiderapp.feed

import io.justdev.droiderapp.api.DroiderApi
import io.justdev.droiderapp.api.FeedModel
import io.reactivex.Observable
import retrofit2.Response

class GetPopularNews(private val api: DroiderApi) : () -> Observable<Response<FeedModel>> {
    override fun invoke(): Observable<Response<FeedModel>> = api.getPopular()
}