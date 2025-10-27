package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import tonix.app.app_shared.core_ui.components.button.AppButton
import tonix.app.app_shared.core_ui.components.button.AppButtonState
import tonix.app.app_shared.core_ui.components.snowflakes_container.SnowflakesContainer
import tonix.app.app_shared.core_ui.components.text_field.AppTextField
import tonix.app.app_shared.core_ui.components.toolbar.ToolbarBackIcon
import tonix.app.app_shared.core_ui.components.toolbar.ToolbarDescription
import tonix.app.app_shared.core_ui.components.toolbar.ToolbarTitle
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.resources.Res
import tonix.app.resources.enter_secret_words_description
import tonix.app.resources.enter_secret_words_title
import tonix.app.resources.paste

@Composable
internal fun ImportWalletMainScreen(
    state: ImportWalletState,
    listener: ImportWalletListener?
) {
    SnowflakesContainer(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            ToolbarBackIcon {
                listener?.onBackClick()
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .navigationBarsPadding()
            ) {
                Toolbar()
                PasteButton()
                InputFields()
                ContinueButton()
            }
        }
    }
}

/**
 * TOOLBAR
 */
@Composable
private fun Toolbar() {
    ToolbarTitle(Res.string.enter_secret_words_title)
    ToolbarDescription(Res.string.enter_secret_words_description)
}

/**
 * PASTE BUTTON
 */
@Composable
private fun PasteButton() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .clip(shapes.extraLarge)
            .background(
                color = colors.backgroundLight,
                shape = shapes.extraLarge
            )
            .clickable {}
    ) {
        Text(
            text = stringResource(Res.string.paste),
            color = colors.text,
            style = typography.body1,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}

/**
 * INPUT FIELDS
 */
@Composable
private fun InputFields() {
    repeat(24) { index ->
        InputField(
            prefix = "${(index + 1)}."
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun InputField(
    prefix: String
) {
    AppTextField(
        value = "",
        onValueChange = {},
        prefix = prefix,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

/**
 * CONTINUE BUTTON
 */
@Composable
private fun ContinueButton() {
    AppButton(
        text = "Continue",
        state = AppButtonState.ACCENT,
        onClick = {},
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 8.dp, bottom = 48.dp)
            .fillMaxWidth()
            .height(56.dp)
    )
}