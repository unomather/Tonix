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
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.CreateImportWalletChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.ImportWalletChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.PinCodeChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.SplashChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.CreateImportWalletConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.ImportWalletConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.PinCodeConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.SplashConfig
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeComponent
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeMainScreen
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashComponent
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashMainScreen
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
     * SCREENS NAVIGATION
     */
    override fun toImportWallet() {
        navigation.pushNew(ImportWalletConfig)
    }

    override fun toPinCode(mode: PinCodeMode) {
        navigation.pushNew(PinCodeConfig(mode))
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
        }
    }
}