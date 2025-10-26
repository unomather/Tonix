package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import tonix.app.app_shared.core_ui.components.button.AppButton
import tonix.app.app_shared.core_ui.components.button.AppButtonState
import tonix.app.app_shared.core_ui.components.snowflakes_container.SnowflakesContainer
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography

@Composable
internal fun CreateImportWalletMainScreen(state: CreateImportWalletState) {
    Content()
}

@Composable
private fun Content() = SnowflakesContainer(
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
        AppName()
        Spacer(modifier = Modifier.weight(1f))
        Description()
        Spacer(modifier = Modifier.weight(1f))
        CreateNewWalletButton()
        ImportExistingWalletButton()
    }
}

@Composable
private fun AppName() {
    Text(
        text = "Tonix",
        color = colors.text,
        style = typography.h1,
        modifier = Modifier
            .clip(shapes.extraLarge)
            .background(
                color = colors.background,
                shape = shapes.extraLarge
            )
    )
}

@Composable
private fun Description() {
    Text(
        text = "Создайте новый или подключите существующий кошелёк",
        color = colors.text,
        style = typography.h3,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .clip(shapes.extraLarge)
            .background(
                color = colors.background,
                shape = shapes.extraLarge
            )
    )
}

@Composable
private fun CreateNewWalletButton() {
    AppButton(
        text = "Создать новый кошелёк",
        state = AppButtonState.ACCENT,
        onClick = {},
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
private fun ImportExistingWalletButton() {
    AppButton(
        text = "Подключить существующий",
        state = AppButtonState.DEFAULT,
        onClick = {},
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(56.dp)
    )
}