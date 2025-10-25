package tonix.app.app_shared.core_ui.view_model

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import pro.respawn.flowmvi.api.ActionShareBehavior
import pro.respawn.flowmvi.api.Container
import pro.respawn.flowmvi.api.PipelineContext
import pro.respawn.flowmvi.api.StateStrategy
import pro.respawn.flowmvi.dsl.StoreBuilder
import pro.respawn.flowmvi.dsl.lazyStore
import pro.respawn.flowmvi.plugins.enableLogging
import pro.respawn.flowmvi.plugins.init
import pro.respawn.flowmvi.plugins.reduce
import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState
import tonix.app.coroutines.AppDispatchers

abstract class BaseViewModel<S: BaseState, I: BaseIntent, A: BaseAction>(
    initialValue: S
): Container<S, I, A>, KoinComponent, InstanceKeeper.Instance {
    /**
     * DATA
     */
    protected val appDispatchers by inject<AppDispatchers>()
    protected val scope = CoroutineScope(SupervisorJob() + appDispatchers.main)
    private var isInitBlockWasExecuted = false

    /**
     * STORE
     */
    override val store by lazyStore(
        scope = scope,
        initial = initialValue
    ) {
        configure {
            name = this@BaseViewModel::class.simpleName!!
            actionShareBehavior = ActionShareBehavior.Distribute()
            coroutineContext = appDispatchers.io
            debuggable = DEBUG
            parallelIntents = true
            stateStrategy = StateStrategy.Immediate
        }
        if (DEBUG) {
            enableLogging(tag = "ViewModelState")
        }
        setupCustomPlugins()
        init {
            if (!isInitBlockWasExecuted) {
                init()
                isInitBlockWasExecuted = true
            }
        }
        reduce { event ->
            handleIntents(event)
        }
    }

    protected open fun StoreBuilder<S, I, A>.setupCustomPlugins() {}
    protected open suspend fun PipelineContext<S, I, A>.init() {}
    protected open suspend fun PipelineContext<S, I, A>.handleIntents(intent: I) {}

    /**
     * INSTANCE KEEPER LIFECYCLE
     */
    override fun onDestroy() {
        scope.cancel()
    }

    /**
     * HELPER
     */
    protected fun io(block: suspend CoroutineScope.() -> Unit) = scope.launch(
        context = appDispatchers.io,
        block = block
    )

    private companion object {
        const val DEBUG = true
    }
}