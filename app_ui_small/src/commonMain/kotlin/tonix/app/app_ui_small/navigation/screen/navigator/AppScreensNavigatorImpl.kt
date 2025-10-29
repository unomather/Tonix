package tonix.app.app_ui_small.navigation.screen.navigator

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceAll
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.AssetsChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.CreateImportWalletChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.ImportWalletChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.MarketChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.SuccessChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.PinCodeChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.SplashChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.AssetsConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.CreateImportWalletConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.ImportWalletConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.MarketConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.SuccessConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.PinCodeConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.SplashConfig
import tonix.app.app_ui_small.navigation.screen.ui.assets.AssetsComponent
import tonix.app.app_ui_small.navigation.screen.ui.assets.AssetsMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.market.MarketComponent
import tonix.app.app_ui_small.navigation.screen.ui.market.MarketMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessComponent
import tonix.app.app_ui_small.navigation.screen.ui.success.SuccessMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeComponent
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashComponent
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenType
import tonix.app.app_ui_small.navigation.screen.ui.success.data.getSuccessScreenDataByType
import kotlin.getValue

internal class AppScreensNavigatorImpl(
    context: ComponentContext,
    private val navigation: StackNavigation<AppScreensConfig>,
): AppScreensNavigator, ComponentContext by context {
    /**
     * ROUTER
     */
    override val router = childStack(
        key = "AppScreensNavigator",
        source = navigation,
        serializer = AppScreensConfig.serializer(),
        initialConfiguration = SplashConfig,
        handleBackButton = true,
        childFactory = ::createChild
    )

    /**
     * CHILD
     */
    private fun createChild(config: AppScreensConfig, context: ComponentContext) = when (config) {
        is SplashConfig -> buildSplashChild(context)
        is CreateImportWalletConfig -> buildCreateImportWalletChild(context)
        is ImportWalletConfig -> buildImportWalletChild(context)
        is PinCodeConfig -> buildPinCodeChild(config, context)
        is SuccessConfig -> buildSuccessChild(config, context)
        is AssetsConfig -> buildAssetsChild(context)
        is MarketConfig -> buildMarketChild(context)
    }

    /**
     * SPLASH
     */
    private fun buildSplashChild(context: ComponentContext) = run {
        val splashComponent by inject<SplashComponent> { parametersOf(context, navigation) }
        SplashChild(splashComponent)
    }

    @Composable
    private fun SplashContent(child: SplashChild) {
        child.component.subscribeState()
        SplashMainScreen()
    }

    /**
     * CREATE IMPORT WALLET
     */
    private fun buildCreateImportWalletChild(context: ComponentContext) = run {
        val createImportWalletComponent by inject<CreateImportWalletComponent> { parametersOf(context) }
        CreateImportWalletChild(createImportWalletComponent)
    }

    @Composable
    private fun CreateImportWalletContent(child: CreateImportWalletChild) {
        child.component.subscribeState()
        CreateImportWalletMainScreen(child.component)
    }

    /**
     * IMPORT WALLET
     */
    private fun buildImportWalletChild(context: ComponentContext) = run {
        val importWalletComponent by inject<ImportWalletComponent> { parametersOf(context) }
        ImportWalletChild(importWalletComponent)
    }

    @Composable
    private fun ImportWalletContent(child: ImportWalletChild) {
        val state by child.component.subscribeState()
        ImportWalletMainScreen(
            state = state,
            listener = child.component
        )
    }

    /**
     * PIN CODE
     */
    private fun buildPinCodeChild(config: PinCodeConfig, context: ComponentContext) = run {
        val pinCodeComponent by inject<PinCodeComponent> { parametersOf(config.mode, context) }
        PinCodeChild(pinCodeComponent)
    }

    @Composable
    private fun PinCodeContent(child: PinCodeChild) {
        val state by child.component.subscribeState()
        PinCodeMainScreen(
            state = state,
            listener = child.component
        )
    }
    /**
     * SUCCESS
     */
    private fun buildSuccessChild(config: SuccessConfig, context: ComponentContext) = run {
        val successScreenData = getSuccessScreenDataByType(config.type)
        val component by inject<SuccessComponent> { parametersOf(context, successScreenData) }
        SuccessChild(component)
    }

    @Composable
    private fun SuccessContent(child: SuccessChild) {
        val state by child.component.subscribeState()
        SuccessMainScreen(
            state = state,
            listener = child.component
        )
    }

    /**
     * ASSETS
     */
    private fun buildAssetsChild(context: ComponentContext) = run {
        val component by inject<AssetsComponent> { parametersOf(context) }
        AssetsChild(component)
    }

    @Composable
    private fun AssetsContent(child: AssetsChild) {
        val state by child.component.subscribeState()
        AssetsMainScreen(
            state = state,
            listener = child.component
        )
    }

    /**
     * MARKET
     */
    private fun buildMarketChild(context: ComponentContext) = run {
        val component by inject<MarketComponent> { parametersOf(context) }
        MarketChild(component)
    }

    @Composable
    private fun MarketContent(child: MarketChild) {
        val state by child.component.subscribeState()
        MarketMainScreen(
            state = state,
            listener = child.component
        )
    }

    /**
     * SCREENS NAVIGATION
     */
    override fun toImportWallet() {
        navigation.pushNew(ImportWalletConfig)
    }

    override fun toPinCode(mode: PinCodeMode) {
        navigation.pushNew(PinCodeConfig(mode))
    }

    override fun toSuccess(type: SuccessScreenType) {
        navigation.pushNew(SuccessConfig(type))
    }

    override fun toAssets() {
        navigation.replaceAll(AssetsConfig)
    }

    override fun toMarket() {
        navigation.replaceAll(MarketConfig)
    }

    /**
     * BACK NAVIGATION
     */
    override fun navigateBack() {
        navigation.pop()
    }

    /**
     * CONTENT
     */
    @OptIn(ExperimentalSharedTransitionApi::class)
    @Composable
    context(visibility: AnimatedVisibilityScope)
    override fun getContentByChild(child: AppScreensChild) = SharedTransitionLayout {
        when (child) {
            is SplashChild -> SplashContent(child)
            is CreateImportWalletChild -> CreateImportWalletContent(child)
            is ImportWalletChild -> ImportWalletContent(child)
            is PinCodeChild -> PinCodeContent(child)
            is SuccessChild -> SuccessContent(child)
            is AssetsChild -> AssetsContent(child)
            is MarketChild -> MarketContent(child)
        }
    }
}