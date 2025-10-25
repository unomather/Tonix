package tonix.app.app_ui_small.navigation.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.named
import pro.respawn.flowmvi.api.Store
import tonix.app.app_shared.core_ui.`typealias`.ComposeState
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

private typealias SS = BaseState
private typealias II = BaseIntent
private typealias AA = BaseAction
private typealias CC = ComponentContext

/**
 * DEFAULT IMPLEMENTATION
 */
abstract class BaseChildComponent<S: SS, I: II, A: AA, VM: BaseViewModel<S, I, A>>(
    context: ComponentContext,
    private val viewModel: VM,
): Store<S, I, A> by viewModel.store, CC by context, KoinComponent {
    @Composable
    abstract fun subscribeState(): ComposeState<S>
}