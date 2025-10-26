package tonix.app.app_shared.core_ui.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.calculateSizeAndSetTo(sizeHolder: MutableState<Dp>): Modifier {
    val density = LocalDensity.current
    return onSizeChanged { size ->
        sizeHolder.value = size.height.dp / density.density
    }
}