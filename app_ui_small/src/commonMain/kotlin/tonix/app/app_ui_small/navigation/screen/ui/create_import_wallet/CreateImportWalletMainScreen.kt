package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import tonix.app.app_shared.core_ui.components.button.AppButton
import tonix.app.app_shared.core_ui.components.button.AppButtonState
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.components.snowflakes_container.SnowflakesContainer
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.resources.Res
import tonix.app.resources.create_import_wallet
import tonix.app.resources.create_new_wallet
import tonix.app.resources.ic_app_logo_foreground
import tonix.app.resources.import_existing_wallet

@Composable
internal fun CreateImportWalletMainScreen(listener: CreateImportWalletListener?) {
    Content(listener)
}

@Composable
private fun Content(listener: CreateImportWalletListener?) = SnowflakesContainer(
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
        Description()
        Spacer(modifier = Modifier.weight(1f))
        CreateNewWalletButton(listener)
        ImportExistingWalletButton(listener)
    }
}

@Composable
private fun AppLogo() {
    AppImage(
        image = Res.drawable.ic_app_logo_foreground,
        modifier = Modifier
            .padding(top = 16.dp)
            .size(64.dp)
    )
}

@Composable
private fun Description() {
    Text(
        text = stringResource(Res.string.create_import_wallet),
        color = colors.text,
        style = typography.h3,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
    )
}

@Composable
private fun CreateNewWalletButton(listener: CreateImportWalletListener?) {
    AppButton(
        text = stringResource(Res.string.create_new_wallet),
        state = AppButtonState.ACCENT,
        onClick = { listener?.onCreateWalletClick() },
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
private fun ImportExistingWalletButton(listener: CreateImportWalletListener?) {
    AppButton(
        text = stringResource(Res.string.import_existing_wallet),
        state = AppButtonState.DEFAULT,
        onClick = { listener?.onImportWalletClick() },
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(56.dp)
    )
}