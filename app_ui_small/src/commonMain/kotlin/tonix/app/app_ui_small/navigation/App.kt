package tonix.app.app_ui_small.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.experimental.stack.ChildStack
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

@Composable
fun AppSmall(appComponentContext: ComponentContext) {
    val appComponent = koinInject<AppComponent> { parametersOf(appComponentContext) }
    Screens(appComponent.navigator)
}

@OptIn(ExperimentalDecomposeApi::class)
@Composable
private fun Screens(appNavigator: AppNavigator) {
    val navigator = appNavigator.appScreensNavigator
    val childStack by navigator.router.subscribeAsState()
    ChildStack(
        stack = childStack,
        content = { child -> navigator.getContentByChild(child.instance) },
        modifier = Modifier.fillMaxSize()
    )
}