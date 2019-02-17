package io.justdev.droiderapp.feed

import io.justdev.droiderapp.api.DroiderApi
import io.justdev.droiderapp.api.FeedModel
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by Jackson on 05/08/2017.
 */
class FeedLoadingInteractor(private val api: DroiderApi) :
        (String, String, Int, Int) -> Observable<Response<FeedModel>> {

    override fun invoke(category: String, slug: String, count: Int, offset: Int): Observable<Response<FeedModel>> {
        return api.getFeed(category, slug, count, offset)
    }
}