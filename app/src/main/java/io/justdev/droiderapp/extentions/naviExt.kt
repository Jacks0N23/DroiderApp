package io.justdev.droiderapp.extentions

import com.trello.navi2.Event
import com.trello.navi2.NaviComponent
import com.trello.navi2.rx.RxNavi
import io.reactivex.Observable

fun <T> NaviComponent.observe(event: Event<T>): Observable<T> = RxNavi.observe(this, event)