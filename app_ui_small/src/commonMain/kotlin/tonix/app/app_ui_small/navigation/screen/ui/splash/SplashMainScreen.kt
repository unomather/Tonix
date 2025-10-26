package tonix.app.app_ui_small.navigation.screen.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.resources.Res
import tonix.app.resources.ic_app_logo_foreground_splash

@Composable
internal fun SplashMainScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        AppImage(
            image = Res.drawable.ic_app_logo_foreground_splash,
            color = colors.text
        )
    }
}