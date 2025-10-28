package tonix.app.app_ui_small.navigation.screen.ui.success

import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenData

internal class SuccessViewModel(
    data: SuccessScreenData
): BaseViewModel<SuccessState, SuccessIntent, SuccessAction>(
    initialValue = SuccessState(data)
)