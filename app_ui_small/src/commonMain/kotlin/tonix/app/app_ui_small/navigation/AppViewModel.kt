package tonix.app.app_ui_small.navigation

import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.AppIntent.SetBottomNavigationTab
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationItem
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationPublisher

private typealias Ctx = PipelineContext<AppState, AppIntent, AppAction>

internal class AppViewModel(
    private val bottomNavigationPublisher: BottomNavigationPublisher
): BaseViewModel<AppState, AppIntent, AppAction>(
    initialValue = AppState()
) {
    override suspend fun Ctx.init() {
        subscribeOnBottomNavigationTab()
    }

    override suspend fun Ctx.handleIntents(intent: AppIntent) {
        when (intent) {
            is SetBottomNavigationTab -> setBottomNavigationTab(intent.tab)
        }
    }

    private fun Ctx.subscribeOnBottomNavigationTab() = io {
        bottomNavigationPublisher.selectedTab.collect { tab ->
            updateState { copy(selectedBottomNavigationTab = tab) }
        }
    }

    private suspend fun setBottomNavigationTab(tab: BottomNavigationItem) {
        bottomNavigationPublisher.showScreenByTab(tab)
    }
}