package tonix.app.app_shared.core_ui.platform

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
actual fun getScreenWidth() = LocalConfiguration.current
    .screenWidthDp
    .dp

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
actual fun getScreenHeight() = LocalConfiguration.current
    .screenHeightDp
    .dp