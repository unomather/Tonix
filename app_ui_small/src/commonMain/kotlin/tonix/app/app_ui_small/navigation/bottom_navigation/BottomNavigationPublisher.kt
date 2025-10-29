package tonix.app.app_ui_small.navigation.bottom_navigation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tonix.app.app_shared.ui.base.app_scope.AppScope
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationItem.*
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator
import tonix.app.coroutines.AppDispatchers

internal interface BottomNavigationPublisher {
    val selectedTab: Flow<BottomNavigationItem?>
    suspend fun showScreenByTab(tab: BottomNavigationItem)
}

internal class BottomNavigationPublisherImpl(
    private val appScope: AppScope,
    private val appDispatchers: AppDispatchers,
    private val navigator: AppScreensNavigator
): BottomNavigationPublisher {
    /**
     * DATA
     */
    override val selectedTab = MutableStateFlow<BottomNavigationItem?>(null)

    /**
     * INIT
     */
    init {
        subscribeOnSelectedTab()
    }

    private fun subscribeOnSelectedTab() = appScope.scope.launch {
        withContext(appDispatchers.main) {
            navigator.router.subscribe { stack ->
                val child = stack.active.instance
                setSelectedTab(child)
            }
        }
    }

    private fun setSelectedTab(child: AppScreensChild) = appScope.scope.launch {
        selectedTab.emit(child.bottomNavigationTab)
    }

    /**
     * SCREEN BY TAB
     */
    override suspend fun showScreenByTab(tab: BottomNavigationItem) = withContext(appDispatchers.main) {
        with(navigator) {
            when (tab) {
                is Assets -> toAssets()
                is Market -> toMarket()
                is DApps -> {}
            }
        }
    }
}