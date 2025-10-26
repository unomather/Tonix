package tonix.app.app_ui_small.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.experimental.stack.ChildStack
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import tonix.app.app_shared.core_ui.theme.AppTheme

@Composable
fun AppSmall(appComponentContext: ComponentContext) {
    val appComponent = koinInject<AppComponent> { parametersOf(appComponentContext) }
    AppTheme {
        Screens(appComponent.navigator)
    }
}

@OptIn(ExperimentalDecomposeApi::class)
@Composable
private fun Screens(appNavigator: AppNavigator) {
    val navigator = appNavigator.appScreensNavigator
    val childStack by navigator.router.subscribeAsState()
    ChildStack(
        stack = childStack,
        animation = stackAnimation(slide()),
        content = { child -> navigator.getContentByChild(child.instance) },
        modifier = Modifier.fillMaxSize()
    )
}