package tonix.app.app_ui_small.navigation.screen.ui.splash

import kotlinx.coroutines.delay
import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashAction.NavigateToCreateImportWallet

private typealias Ctx = PipelineContext<SplashState, SplashIntent, SplashAction>

internal class SplashViewModel: BaseViewModel<SplashState, SplashIntent, SplashAction>(SplashState.Default) {
    override suspend fun Ctx.init() {
        delay(3000)
        action(NavigateToCreateImportWallet)
    }
}