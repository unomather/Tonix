package tonix.app.app_ui_small.navigation.base

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.Job
import org.koin.core.component.KoinComponent
import tonix.app.app_shared.core_ui.components.slot_content.SlotContentType

abstract class BaseSlotRootNavigator<Config: BaseSlotConfig, Child: BaseSlotChild>(
    open val context: ComponentContext
): KoinComponent, ComponentContext by context {
    /**
     * ROUTER
     */
    abstract val router: Value<ChildSlot<Config, Child>>
    protected val navigation = SlotNavigation<Config>()

    /**
     * BACK NAVIGATION
     */
    var onCompleteCallback: () -> Unit = {}
    abstract var backNavigationCallback: () -> Job

    fun onDismiss() = backNavigationCallback().invokeOnCompletion {
        navigation.dismiss {
            onCompleteCallback()
            onCompleteCallback = {}
        }
    }

    /**
     * CONTENT
     */
    abstract val contentType: SlotContentType

    @Composable
    abstract fun getContentByChild(child: Child)
}
