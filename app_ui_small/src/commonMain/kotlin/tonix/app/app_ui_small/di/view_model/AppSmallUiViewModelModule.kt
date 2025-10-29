package tonix.app.app_ui_small.di.view_model

import com.arkivanov.decompose.ComponentContext
import org.koin.core.module.dsl.factoryOf
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import tonix.app.app_ui_small.navigation.AppViewModel
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationPublisher
import tonix.app.app_ui_small.navigation.screen.ui.assets.AssetsViewModel
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletViewModel
import tonix.app.app_ui_small.navigation.screen.ui.dapps.DAppsViewModel
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletViewModel
import tonix.app.app_ui_small.navigation.screen.ui.market.MarketViewModel
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessViewModel
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeViewModel
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashViewModel

val moduleAppSmallUiViewModel = module {
    /**
     * APP
     */
    factory { (context: ComponentContext) ->
        AppViewModel(
            bottomNavigationPublisher = get<BottomNavigationPublisher> { parametersOf(context) }
        )
    }
    /**
     * SCREENS
     */
    factoryOf(::SplashViewModel)
    factoryOf(::CreateImportWalletViewModel)
    factoryOf(::ImportWalletViewModel)
    factoryOf(::PinCodeViewModel)
    factoryOf(::SuccessViewModel)
    factoryOf(::AssetsViewModel)
    factoryOf(::MarketViewModel)
    factoryOf(::DAppsViewModel)
}