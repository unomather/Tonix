package tonix.app.app_ui_small.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.AppIntent.SetBottomNavigationTab
import tonix.app.app_ui_small.navigation.base.BaseChildComponent
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationItem

internal class AppComponent(
    context: ComponentContext,
    viewModel: AppViewModel,
    val navigator: AppNavigator
): AppListener, BaseChildComponent<AppState, AppIntent, AppAction, AppViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe()

    /**
     * LISTENER
     */
    override fun selectBottomNavigationTab(tab: BottomNavigationItem) {
        intent(SetBottomNavigationTab(tab))
    }
}