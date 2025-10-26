package tonix.app.app_shared.core_ui.di

import androidx.compose.ui.text.font.FontFamily
import org.koin.dsl.module
import tonix.app.app_shared.core_ui.theme.colors.AppColors
import tonix.app.app_shared.core_ui.theme.colors.AppColorsImpl
import tonix.app.app_shared.core_ui.theme.shape.AppShapes
import tonix.app.app_shared.core_ui.theme.shape.AppShapesImpl
import tonix.app.app_shared.core_ui.theme.typography.AppTypography
import tonix.app.app_shared.core_ui.theme.typography.AppTypographyImpl

val moduleAppSharedCoreUi = module {
    /**
     * COLORS
     */
    single<AppColors> { AppColorsImpl() }
    /**
     * SHAPES
     */
    single<AppShapes> { AppShapesImpl() }
    /**
     * TYPOGRAPHY
     */
    single<AppTypography> { (fontFamily: FontFamily) ->
        AppTypographyImpl(fontFamily)
    }
}