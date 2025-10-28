package tonix.app.app_ui_small.navigation.screen.ui.success

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenData

internal sealed interface SuccessIntent: BaseIntent

internal data class SuccessState(
    val data: SuccessScreenData
): BaseState

internal sealed interface SuccessAction: BaseAction

internal interface SuccessListener