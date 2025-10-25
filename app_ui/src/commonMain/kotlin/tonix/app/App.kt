package tonix.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.arkivanov.decompose.ComponentContext
import org.jetbrains.compose.ui.tooling.preview.Preview
import tonix.app.app_ui_small.navigation.AppSmall

@Composable
@Preview
fun App(appComponentContext: ComponentContext) {
    MaterialTheme {
        AppSmall(appComponentContext)
    }
}