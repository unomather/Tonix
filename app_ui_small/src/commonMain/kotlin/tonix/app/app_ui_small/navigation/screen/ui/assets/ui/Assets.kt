package tonix.app.app_ui_small.navigation.screen.ui.assets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import tonix.app.app_shared.core_ui.components.button.AppButton
import tonix.app.app_shared.core_ui.components.button.AppButtonState.DEFAULT
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.app_ui_small.navigation.screen.ui.assets.data.AssetUi
import tonix.app.app_ui_small.navigation.screen.ui.assets.data.getTestAssets
import tonix.app.resources.Res
import tonix.app.resources.add_asset
import tonix.app.resources.ic_plus
import tonix.app.resources.my_assets

@Composable
internal fun MyAssets() {
    Column(
        modifier = Modifier
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .clip(shapes.extraLarge)
            .background(
                color = colors.backgroundLight,
                shape = shapes.extraLarge
            )
    ) {
        MyAssetsTitle()
        AssetsList()
    }
    AddAssetButton()
}

@Composable
private fun MyAssetsTitle() {
    Text(
        text = stringResource(Res.string.my_assets),
        color = colors.text,
        style = typography.body1,
        modifier = Modifier.padding(top = 16.dp, start = 16.dp)
    )
}

@Composable
private fun AssetsList() {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        getTestAssets().forEach { asset ->
            Asset(asset)
        }
    }
}

@Composable
private fun Asset(asset: AssetUi) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable {}
            .padding(horizontal = 16.dp)
    ) {
        AppImage(
            image = asset.icon,
            modifier = Modifier
                .size(48.dp)
                .clip(shapes.large)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxHeight()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = asset.name,
                    style = typography.body1.copy(fontWeight = FontWeight.Bold),
                    color = colors.text,
                    modifier = Modifier.padding(end = 4.dp)
                )
                asset.chain?.let {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(shapes.small)
                            .background(
                                color = colors.background,
                                shape = shapes.small
                            )
                            .padding(horizontal = 6.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = asset.chain,
                            color = colors.text,
                            style = typography.sub2
                        )
                    }
                }
            }
            Text(
                text = asset.price,
                style = typography.sub1,
                color = colors.text.copy(alpha = 0.5f),
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = "${asset.balanceTicker} ${asset.ticker}",
                style = typography.body1.copy(fontWeight = FontWeight.Bold),
                color = colors.text
            )
            Text(
                text = "${asset.balanceUsd}$",
                style = typography.sub1,
                color = colors.text.copy(alpha = 0.5f),
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
private fun AddAssetButton() {
    AppButton(
        text = stringResource(Res.string.add_asset),
        state = DEFAULT,
        startIcon = Res.drawable.ic_plus,
        onClick = {},
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
            .height(56.dp)
    )
}