package tonix.app.app_ui_small.navigation.screen.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import org.jetbrains.compose.resources.painterResource
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.resources.Res
import tonix.app.resources.app_logo_foreground

@Composable
internal fun SplashMainScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        Image(
            painter = painterResource(Res.drawable.app_logo_foreground),
            colorFilter = ColorFilter.tint(colors.text),
            contentDescription = ""
        )
    }
}