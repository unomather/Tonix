package tonix.app.app_ui_small.navigation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.experimental.stack.ChildStack
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import tonix.app.app_shared.core_ui.theme.AppTheme
import tonix.app.app_ui_small.navigation.bottom_navigation.AppBottomNavigation
import tonix.app.app_ui_small.navigation.bottom_navigation.BOTTOM_NAVIGATION_HEIGHT

@Composable
fun AppSmall(appComponentContext: ComponentContext) {
    val appComponent = koinInject<AppComponent> { parametersOf(appComponentContext) }
    AppTheme {
        val appState by appComponent.subscribeState()
        AppContent(
            appState = appState,
            appListener = appComponent,
            appNavigator = appComponent.navigator
        )
    }
}

@Composable
private fun AppContent(
    appState: AppState,
    appListener: AppListener,
    appNavigator: AppNavigator
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Screens(appNavigator)
        BottomNavigation(appState, appListener)
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

@Composable
private fun BoxScope.BottomNavigation(
    appState: AppState,
    appListener: AppListener
) {
    val selectedTab = appState.selectedBottomNavigationTab
    val isBottomNavigationVisible = selectedTab != null
    val offset by animateDpAsState(
        animationSpec = tween(),
        targetValue = if (isBottomNavigationVisible) 0.dp else (BOTTOM_NAVIGATION_HEIGHT * 2).dp
    )
    AppBottomNavigation(
        selectedItem = selectedTab,
        onItemClick = appListener::selectBottomNavigationTab,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .offset(y = offset)
    )
}