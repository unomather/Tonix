package tonix.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import tonix.app.app_ui_small.AppSmall

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppSmall()
    }
}