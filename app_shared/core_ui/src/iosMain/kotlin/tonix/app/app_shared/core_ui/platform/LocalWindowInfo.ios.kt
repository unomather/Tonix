package tonix.app.app_shared.core_ui.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenWidth() = with(LocalDensity.current) {
    LocalWindowInfo.current
        .containerSize
        .width
        .dp / density
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenHeight() = with(LocalDensity.current) {
    LocalWindowInfo.current
        .containerSize
        .height
        .dp / density
}