package tonix.app.app_ui_small.navigation.screen.ui.splash

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashAction.NavigateToCreateImportWallet

internal class SplashComponent(
    context: ComponentContext,
    viewModel: SplashViewModel,
    private val navigator: SplashNavigator
): BaseChildComponent<SplashState, SplashIntent, SplashAction, SplashViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe { action ->
        when (action) {
            is NavigateToCreateImportWallet -> navigator.toCreateImportWallet()
        }
    }
}