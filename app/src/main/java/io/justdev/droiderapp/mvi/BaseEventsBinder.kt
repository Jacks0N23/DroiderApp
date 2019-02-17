package io.justdev.droiderapp.mvi

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.tinkoff.mlca.mvi.BaseEvents

abstract class BaseEventsBinder<in EVENTS : BaseEvents>
(private val uiScheduler: Scheduler = AndroidSchedulers.mainThread()) {

    @SuppressLint("CheckResult")
    fun bind(events: EVENTS) {
        bindInternal(events).observeOn(uiScheduler)
                .takeUntil(events.unbindEvent)
                .subscribe { it() }
    }

    protected abstract fun bindInternal(events: EVENTS): Observable<Action>
}