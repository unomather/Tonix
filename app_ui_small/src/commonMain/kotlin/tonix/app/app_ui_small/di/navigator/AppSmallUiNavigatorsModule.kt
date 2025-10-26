package tonix.app.app_ui_small.di.navigator

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import tonix.app.app_ui_small.navigation.AppNavigator
import tonix.app.app_ui_small.navigation.AppNavigatorImpl
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigatorImpl
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletNavigator
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletNavigatorImpl
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletNavigator
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletNavigatorImpl
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashNavigator
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashNavigatorImpl

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
    /**
     * START
     */
    factory<SplashNavigator> { (navigation: StackNavigation<AppScreensConfig>) ->
        SplashNavigatorImpl(navigation = navigation)
    }
    /**
     * CREATE IMPORT WALLET
     */
    factory<CreateImportWalletNavigator> { (context: ComponentContext) ->
        CreateImportWalletNavigatorImpl(
            appScreensNavigator = get<AppScreensNavigator> { parametersOf(context) }
        )
    }
    factory<ImportWalletNavigator> { (context: ComponentContext) ->
        ImportWalletNavigatorImpl(
            appScreensNavigator = get<AppScreensNavigator> { parametersOf(context) }
        )
    }
}