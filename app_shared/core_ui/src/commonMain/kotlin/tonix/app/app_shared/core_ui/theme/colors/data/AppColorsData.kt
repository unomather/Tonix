package tonix.app.app_shared.core_ui.theme.colors.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

data class AppColorsData(
    private val colorLink: Color,
    private val colorText: Color,
    private val colorAccent: Color,
    private val colorBackground: Color,
    private val colorBackgroundLight: Color
) {
    var link by mutableStateOf(colorLink)
        private set

    var text by mutableStateOf(colorText)
        private set

    var accent by mutableStateOf(colorAccent)
        private set

    var background by mutableStateOf(colorBackground)
        private set

    var backgroundLight by mutableStateOf(colorBackgroundLight)
        private set

    fun updateColors(other: AppColorsData) {
        link = other.link
        text = other.text
        background = other.background
        backgroundLight = other.backgroundLight
        accent = other.accent
    }
}