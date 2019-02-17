package io.justdev.droiderapp.di.base

interface ComponentInjector<T> {
    fun component(): T
    fun setComponent(component: T)
    fun isComponentReleased(): Boolean
    fun clear()
}

class SynchronizedComponentInjectorImpl<T> : ComponentInjector<T> {
    private var component: T? = null

    @Synchronized
    override fun component(): T = component ?: throw IllegalStateException("call when component null")

    @Synchronized
    override fun setComponent(component: T) {
        this.component = component
    }

    override fun isComponentReleased(): Boolean {
        return component == null
    }

    @Synchronized
    override fun clear() {
        component = null
    }
}