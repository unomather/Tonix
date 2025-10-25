package tonix.app.app_ui_small.navigation

import tonix.app.app_shared.core_ui.view_model.BaseViewModel

internal class AppViewModel: BaseViewModel<AppState, AppIntent, AppAction>(AppState.Default)