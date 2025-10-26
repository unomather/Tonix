package tonix.app.app_shared.core_ui.theme.window_insets

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import tonix.app.app_shared.core_ui.`typealias`.ComposeState

data class LocalWindowInsetsData(
    private val appTopPadding: Dp,
    private val appBottomPadding: Dp,
    private val isImeVisible: Boolean
) {
    var topPadding by mutableStateOf(appTopPadding)
        private set
    var bottomPadding by mutableStateOf(appBottomPadding)
        private set
    var imeVisible by mutableStateOf(isImeVisible)
        private set

    fun updateInsets(other: LocalWindowInsetsData) {
        topPadding = other.appTopPadding
        bottomPadding = other.appBottomPadding
        imeVisible = other.isImeVisible
    }
}

@Composable
internal fun getWindowInsets(): ComposeState<LocalWindowInsetsData> {
    val data = with(LocalDensity.current) {
        LocalWindowInsetsData(
            appTopPadding = WindowInsets.statusBars.getTop(this).toDp(),
            appBottomPadding = WindowInsets.navigationBars.getBottom(this).toDp(),
            isImeVisible = WindowInsets.ime.getBottom(this) > 0
        )
    }
    return derivedStateOf { data }
}