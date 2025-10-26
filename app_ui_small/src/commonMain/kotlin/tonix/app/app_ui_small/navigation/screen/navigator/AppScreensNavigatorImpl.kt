package tonix.app.app_ui_small.navigation.screen.navigator

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.replaceAll
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.CreateImportWalletChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.SplashChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.CreateImportWalletConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.SplashConfig
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletMainScreen
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
    }

    /**
     * SPLASH
     */
    private fun buildSplashChild(context: ComponentContext) = run {
        val splashComponent by inject<SplashComponent> { parametersOf(context, navigation) }
        SplashChild(splashComponent)
    }

    @OptIn(ExperimentalSharedTransitionApi::class)
    @Composable
    context(transition: SharedTransitionScope, visibility: AnimatedVisibilityScope)
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

    @OptIn(ExperimentalSharedTransitionApi::class)
    @Composable
    context(transition: SharedTransitionScope, visibility: AnimatedVisibilityScope)
    private fun CreateImportWalletContent(child: CreateImportWalletChild) {
        val state by child.component.subscribeState()
        CreateImportWalletMainScreen(state)
    }

    /**
     * SCREENS NAVIGATION
     */
    override fun toSplash() {
        navigation.replaceAll(SplashConfig)
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
        }
    }
}