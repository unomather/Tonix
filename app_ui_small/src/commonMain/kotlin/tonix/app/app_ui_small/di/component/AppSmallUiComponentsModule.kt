package tonix.app.app_ui_small.di.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import tonix.app.app_shared.core_ui.view_model.di.getViewModel
import tonix.app.app_ui_small.navigation.AppComponent
import tonix.app.app_ui_small.navigation.AppNavigator
import tonix.app.app_ui_small.navigation.AppViewModel
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletNavigator
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletViewModel
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashComponent
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashNavigator
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashViewModel

internal val moduleAppSmallUiComponents = module {
    /**
     * APP
     */
    factory { (context: ComponentContext) ->
        AppComponent(
            context = context,
            viewModel = context.getViewModel<AppViewModel> { parametersOf(context) },
            navigator = get<AppNavigator> { parametersOf(context) }
        )
    }
    /**
     * SPLASH
     */
    factory { (context: ComponentContext, navigation: StackNavigation<AppScreensConfig>) ->
        SplashComponent(
            context = context,
            viewModel = context.getViewModel<SplashViewModel>(),
            navigator = get<SplashNavigator> { parametersOf(navigation) }
        )
    }
    /**
     * CREATE IMPORT WALLET
     */
    factory { (context: ComponentContext) ->
        CreateImportWalletComponent(
            context = context,
            viewModel = context.getViewModel<CreateImportWalletViewModel>(),
            navigator = get<CreateImportWalletNavigator> { parametersOf(context) }
        )
    }
}