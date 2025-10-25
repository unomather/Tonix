package tonix.app.app_ui_small.navigation.screen.navigator

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandler

internal interface AppScreensNavigator {
    /**
     * ROUTER
     */
    val router: Value<ChildStack<AppScreensConfig, AppScreensChild>>

    /**
     * SCREENS NAVIGATION
     */
    fun toSplash()

    /**
     * BACK NAVIGATION
     */
    val backHandler: BackHandler
    fun navigateBack()

    /**
     * CONTENT
     */
    @Composable
    fun getContentByChild(child: AppScreensChild)
}