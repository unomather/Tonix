package tonix.app.app_ui_small.navigation.screen.ui.operation

import tonix.app.app_shared.core_ui.view_model.BaseViewModel

internal class OperationViewModel: BaseViewModel<OperationState, OperationIntent, OperationAction>(
    OperationState.Default
)