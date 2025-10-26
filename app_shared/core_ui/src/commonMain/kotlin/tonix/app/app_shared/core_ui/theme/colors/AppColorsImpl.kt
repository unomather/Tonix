package tonix.app.app_shared.core_ui.theme.colors

import tonix.app.app_shared.core_ui.theme.colors.data.AppColorsData
import tonix.app.app_shared.core_ui.theme.colors.data.appDarkColors
import tonix.app.app_shared.core_ui.theme.colors.data.appLightColors

internal class AppColorsImpl(
    override val appColorsDark: AppColorsData = appDarkColors,
    override val appColorsLight: AppColorsData = appLightColors
): AppColors