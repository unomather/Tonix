package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.components.snowflakes_container.SnowflakesContainer
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.app_shared.core_ui.theme.PreviewAppTheme
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.AppLogo
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.EmptySpace
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeDigit
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeIcon
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.getPinCodeItems
import tonix.app.resources.Res
import tonix.app.resources.forgot_pin_code

@Composable
internal fun PinCodeMainScreen(
    state: PinCodeState,
    listener: PinCodeListener?
) {
    SnowflakesContainer(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            AppLogo()
            Spacer(modifier = Modifier.weight(1f))
            Title(state)
            Dots()
            DigitsGrid(
                state = state,
                listener = listener
            )
            if (state.isForgotPinCodeTextVisible) {
                ForgotPinText()
            } else {
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}

/**
 * DESCRIPTION
 */
@Composable
private fun Title(state: PinCodeState) {
    Text(
        text = state.title,
        color = colors.text,
        style = typography.body1.copy(fontWeight = FontWeight.Bold)
    )
}

/**
 * DOTS
 */
@Composable
private fun Dots() {
    Row(
        modifier = Modifier.padding(vertical = 32.dp)
    ) {
        repeat(6) { index ->
            Dot()
            if (index != 5) {
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
private fun Dot() {
    Box(
        modifier = Modifier
            .size(16.dp)
            .clip(shapes.circle)
            .background(
                color = colors.backgroundLight,
                shape = shapes.circle
            )
    )
}

/**
 * DIGITS
 */
@Composable
private fun DigitsGrid(
    state: PinCodeState,
    listener: PinCodeListener?
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(state.pinCodeItems) { item ->
            Digit(item)
        }
    }
}

@Composable
private fun Digit(item: PinCodeItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(80.dp)
            .clip(shapes.circle)
            .background(
                color = if (item is PinCodeDigit) colors.backgroundLight else Color.Transparent,
                shape = shapes.circle
            )
    ) {
        when (item) {
            is PinCodeDigit -> Text(
                text = item.value.toString(),
                color = colors.text,
                style = typography.h1.copy(fontWeight = FontWeight.Normal)
            )
            is PinCodeIcon -> AppImage(
                image = item.value,
                color = colors.text
            )
            is EmptySpace -> Unit
        }
    }
}

/**
 * FORGOT PIN
 */
@Composable
private fun ForgotPinText() {
    Text(
        text = stringResource(Res.string.forgot_pin_code),
        color = colors.text,
        style = typography.body1,
        modifier = Modifier.padding(vertical = 48.dp)
    )
}

/**
 * PREVIEWS
 */
@Preview
@Composable
private fun CreatePinCodePreview() = PreviewAppTheme {
    PinCodeMainScreen(
        state = PinCodeState(
            pinCodeItems = getPinCodeItems(PinCodeMode.CREATE),
            isForgotPinCodeTextVisible = false
        ),
        listener = null
    )
}

@Preview
@Composable
private fun CheckPinCodePreview() = PreviewAppTheme {
    PinCodeMainScreen(
        state = PinCodeState(
            pinCodeItems = getPinCodeItems(PinCodeMode.CHECK),
            isForgotPinCodeTextVisible = true
        ),
        listener = null
    )
}