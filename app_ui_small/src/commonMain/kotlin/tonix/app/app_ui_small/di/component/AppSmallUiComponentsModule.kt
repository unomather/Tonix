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
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletNavigator
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletViewModel
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessComponent
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessNavigator
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessViewModel
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeComponent
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeNavigator
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeViewModel
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
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
    factory { (context: ComponentContext) ->
        ImportWalletComponent(
            context = context,
            viewModel = context.getViewModel<ImportWalletViewModel>(),
            navigator = get<ImportWalletNavigator> { parametersOf(context) }
        )
    }
    /**
     * PIN CODE
     */
    factory { (mode: PinCodeMode, context: ComponentContext) ->
        PinCodeComponent(
            context = context,
            viewModel = context.getViewModel<PinCodeViewModel> { parametersOf(mode) },
            navigator = get<PinCodeNavigator> { parametersOf(context) }
        )
    }
    /**
     * SUCCESS
     */
    factory { (context: ComponentContext) ->
        SuccessComponent(
            context = context,
            viewModel = context.getViewModel<SuccessViewModel>(),
            navigator = get<SuccessNavigator> { parametersOf(context) }
        )
    }
}