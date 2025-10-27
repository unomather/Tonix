package tonix.app.app_shared.core_ui.components.text_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    prefix: String? = null,
    modifier: Modifier = Modifier
) {
    var inputValue by rememberSaveable { mutableStateOf(value) }
    var searchWasTriggered by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        snapshotFlow { inputValue }.onEach { value ->
            if (searchWasTriggered) onValueChange(value)
        }.launchIn(this)
    }
    TextField(
        value = inputValue,
        onValueChange = { newValue ->
            searchWasTriggered = true
            inputValue = newValue
        },
        prefix = prefix?.let {{
            Text(
                text = prefix,
                color = colors.text.copy(alpha = 0.5f),
                style = typography.body1,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }},
        colors = TextFieldDefaults.colors(
            cursorColor = colors.text,
            focusedTextColor = colors.text,
            disabledTextColor = colors.text,
            unfocusedTextColor = colors.text,
            errorTextColor = colors.text,
            focusedContainerColor = colors.backgroundLight,
            disabledContainerColor = colors.backgroundLight,
            unfocusedContainerColor = colors.backgroundLight,
            errorContainerColor = colors.backgroundLight,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(shapes.extraLarge)
    )
}