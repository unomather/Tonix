package tonix.app.app_ui_small.navigation.screen.navigator

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandler
import org.koin.core.component.KoinComponent

internal interface AppScreensNavigator: KoinComponent {
    /**
     * ROUTER
     */
    val router: Value<ChildStack<AppScreensConfig, AppScreensChild>>

    /**
     * SCREENS NAVIGATION
     */
    fun toImportWallet()
    fun toPinCode()

    /**
     * BACK NAVIGATION
     */
    val backHandler: BackHandler
    fun navigateBack()

    /**
     * CONTENT
     */
    @Composable
    context(visibility: AnimatedVisibilityScope)
    fun getContentByChild(child: AppScreensChild)
}