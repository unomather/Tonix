package tonix.app.app_ui_small.di.bottom_navigation

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import tonix.app.app_shared.ui.base.app_scope.AppScope
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationPublisher
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationPublisherImpl
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator
import tonix.app.coroutines.AppDispatchers

internal val moduleAppSmallUiBottomNavigation = module {
    single<BottomNavigationPublisher> { (context: ComponentContext) ->
        BottomNavigationPublisherImpl(
            appScope = get<AppScope>(),
            appDispatchers = get<AppDispatchers>(),
            navigator = get<AppScreensNavigator> { parametersOf(context) }
        )
    }
}