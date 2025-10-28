package tonix.app.app_ui_small.di.view_model

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import tonix.app.app_ui_small.navigation.AppViewModel
import tonix.app.app_ui_small.navigation.screen.ui.assets.AssetsViewModel
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletViewModel
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletViewModel
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessViewModel
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeViewModel
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashViewModel

val moduleAppSmallUiViewModel = module {
    factoryOf(::AppViewModel)
    factoryOf(::SplashViewModel)
    factoryOf(::CreateImportWalletViewModel)
    factoryOf(::ImportWalletViewModel)
    factoryOf(::PinCodeViewModel)
    factoryOf(::SuccessViewModel)
    factoryOf(::AssetsViewModel)
}