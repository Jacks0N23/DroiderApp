package io.justdev.droiderapp.navigation.dashboard

import io.justdev.droiderapp.Consts
import io.justdev.droiderapp.R
import io.justdev.droiderapp.api.FeedModel
import io.justdev.droiderapp.arch.ViewTyped
import io.justdev.droiderapp.mvi.Action
import io.justdev.droiderapp.mvi.ActionCreator
import io.justdev.droiderapp.mvi.ActionMapper
import io.justdev.droiderapp.mvi.EventObservable
import io.reactivex.Observable
import retrofit2.Response

class LoadFeedItemsActionCreator(private val feedLoadingInteractor: (String, String, Int, Int) -> Observable<Response<FeedModel>>,
                                 private val showLoadedFeedItems: ActionMapper<List<ViewTyped>>,
                                 private val showLoading: Action,
                                 private val showError: Action) : ActionCreator<EventObservable> {

    override fun invoke(event: EventObservable): Observable<Action> {
        return event.flatMap {
            feedLoadingInteractor(Consts.CATEGORY_MAIN, Consts.SLUG_MAIN, Consts.DEFAULT_COUNT, 0).map {
                if (it.isSuccessful.not()) showError
                else {
                    //TODO make ui model for posts
                    val posts = it.body()
                            ?.posts?.map { it.copy(viewType = R.layout.item_article_card) }
                    posts?.let { it1 -> showLoadedFeedItems(it1) } ?: showError
                }
            }
                    .onErrorReturnItem(showError)
                    .startWith(showLoading)
        }
    }
}