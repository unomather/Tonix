package tonix.app.app_ui_small.navigation.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackCallback
import com.arkivanov.essenty.backhandler.BackHandler

fun BaseChild.setBackHandler(context: ComponentContext, navigateBack: () -> Unit) = BackCallback(
    isEnabled = true,
    onBack = {
        if (isSystemBackEnabled) navigateBack()
    }
).also { backCallback ->
    context.backHandler.register(backCallback)
}

@Composable
fun BackHandler(
    backHandler: BackHandler,
    isEnabled: Boolean = true,
    onBack: () -> Unit
) {
    val currentOnBack by rememberUpdatedState(onBack)
    val callback = remember {
        BackCallback(isEnabled = isEnabled) {
            currentOnBack()
        }
    }
    SideEffect {
        callback.isEnabled = isEnabled
    }
    DisposableEffect(backHandler) {
        backHandler.register(callback)
        onDispose {
            backHandler.unregister(callback)
        }
    }
}
