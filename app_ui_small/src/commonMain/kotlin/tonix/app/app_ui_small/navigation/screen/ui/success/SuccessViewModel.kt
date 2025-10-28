package tonix.app.app_ui_small.navigation.screen.ui.success

import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessAction.NavigateToAssets
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessIntent.OnContinueClicked
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenData

private typealias Ctx = PipelineContext<SuccessState, SuccessIntent, SuccessAction>

internal class SuccessViewModel(
    data: SuccessScreenData
): BaseViewModel<SuccessState, SuccessIntent, SuccessAction>(
    initialValue = SuccessState(data)
) {
    override suspend fun Ctx.handleIntents(intent: SuccessIntent) {
        when (intent) {
            is OnContinueClicked -> action(NavigateToAssets)
        }
    }
}