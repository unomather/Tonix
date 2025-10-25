package tonix.app.app_ui_small.navigation.screen.navigator

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.replaceAll
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensChild.SplashChild
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.SplashConfig
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashMainScreen

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
        is SplashConfig -> buildSplashChild()
    }

    /**
     * SPLASH
     */
    private fun buildSplashChild() = SplashChild

    @Composable
    private fun SplashContent() = SplashMainScreen()

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
    @Composable
    override fun getContentByChild(child: AppScreensChild) = when (child) {
        is SplashChild -> SplashContent()
    }
}