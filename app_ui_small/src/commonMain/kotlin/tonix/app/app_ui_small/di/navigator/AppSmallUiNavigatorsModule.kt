package tonix.app.app_ui_small.di.navigator

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import tonix.app.app_ui_small.navigation.AppNavigator
import tonix.app.app_ui_small.navigation.AppNavigatorImpl
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigatorImpl

internal val moduleAppSmallUiNavigators = module {
    /**
     * APP
     */
    single<AppNavigator> { (context: ComponentContext) ->
        AppNavigatorImpl(
            appScreensNavigator = get<AppScreensNavigator> { parametersOf(context) }
        )
    }
    single<AppScreensNavigator> { (context: ComponentContext) ->
        AppScreensNavigatorImpl(
            context = context,
            navigation = StackNavigation(),
        )
    }
}