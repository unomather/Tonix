package tonix.app.app_shared.core_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import org.koin.compose.koinInject
import tonix.app.app_shared.core_ui.theme.colors.AppColors
import tonix.app.app_shared.core_ui.theme.colors.data.AppColorsData
import tonix.app.app_shared.core_ui.theme.shape.AppShapes
import tonix.app.app_shared.core_ui.theme.typography.AppTypography
import tonix.app.app_shared.core_ui.theme.window_insets.LocalWindowInsetsData
import tonix.app.app_shared.core_ui.theme.window_insets.getWindowInsets
import tonix.app.resources.Res
import tonix.app.resources.inter_black
import tonix.app.resources.inter_bold
import tonix.app.resources.inter_extra_bold
import tonix.app.resources.inter_medium
import tonix.app.resources.inter_regular
import tonix.app.resources.inter_semi_bold

/**
 * CUSTOM THEME
 */
object CustomTheme {
    val colors: AppColorsData
        @Composable
        get() = LocalAppColorsData.current
    val shapes: AppShapes
        @Composable
        get() = LocalShapes.current
    val typography: AppTypography
        @Composable
        get() = LocalTypography.current
}

/**
 * THEME
 */
@Composable
internal fun ProvideCustomTheme(
    typography: AppTypography,
    colors: AppColors = koinInject<AppColors>(),
    shapes: AppShapes = koinInject<AppShapes>(),
    windowInsets: LocalWindowInsetsData = getWindowInsets().value,
    content: @Composable () -> Unit
) {
    // App colors
    val colorPalette by rememberUpdatedState(colors.appColorsLight)
    colorPalette.updateColors(colorPalette)
    // App typography
    val appTypography by rememberUpdatedState(typography)
    // App window insets
    val insets by rememberUpdatedState(windowInsets)
    insets.updateInsets(insets)
    // Provider
    CompositionLocalProvider(
        LocalAppColorsData provides colorPalette,
        LocalShapes provides shapes,
        LocalTypography provides appTypography,
        LocalWindowInsets provides insets,
    ) {
        content()
    }
}

/**
 * FONT FAMILY
 */
@Composable
internal fun getAppFontFamily() = FontFamily(
    Font(
        resource = Res.font.inter_regular,
        weight = FontWeight.W400
    ),
    Font(
        resource = Res.font.inter_medium,
        weight = FontWeight.W500
    ),
    Font(
        resource = Res.font.inter_semi_bold,
        weight = FontWeight.W600
    ),
    Font(
        resource = Res.font.inter_bold,
        weight = FontWeight.W700
    ),
    Font(
        resource = Res.font.inter_extra_bold,
        weight = FontWeight.W800
    ),
    Font(
        resource = Res.font.inter_black,
        weight = FontWeight.W900
    )
)

/**
 * LOCAL COMPOSITIONS
 */
val LocalAppColorsData = staticCompositionLocalOf<AppColorsData> {
    error("No AppColorsData set")
}
val LocalShapes = staticCompositionLocalOf<AppShapes> {
    error("No AppShapes set")
}
val LocalTypography = staticCompositionLocalOf<AppTypography> {
    error("No AppTypography set")
}
val LocalWindowInsets = staticCompositionLocalOf<LocalWindowInsetsData> {
    error("No LocalWindowInsetsData set")
}