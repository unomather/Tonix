package tonix.app.app_ui_small

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppSmall() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
}