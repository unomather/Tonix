package tonix.app.app_ui_small.navigation.screen.ui.assets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.resources.Res
import tonix.app.resources.ic_exchange
import tonix.app.resources.ic_receive
import tonix.app.resources.ic_send
import tonix.app.resources.receive
import tonix.app.resources.send

@Composable
internal fun AssetsSendReceiveExchangeButtons() {
    ConstraintLayout(
        modifier = Modifier
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .height(80.dp)
    ) {
        val (sendButton, receiveButton, exchangeButton, background) = createRefs()
        Box(
            modifier = Modifier
                .height(56.dp)
                .clip(shapes.extraLarge)
                .background(colors.backgroundLight)
                .constrainAs(background) {
                    centerTo(parent)
                    width = Dimension.fillToConstraints
                }
        )
        ExchangeButton(
            modifier = Modifier.constrainAs(exchangeButton) { centerTo(parent) }
        )
        SendReceiveButton(
            text = Res.string.send,
            icon = Res.drawable.ic_send,
            modifier = Modifier.constrainAs(sendButton) {
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                top.linkTo(background.top, margin = 4.dp)
                bottom.linkTo(background.bottom, margin = 4.dp)
                start.linkTo(background.start, margin = 4.dp)
                end.linkTo(exchangeButton.start, margin = 4.dp)
            }
        )
        SendReceiveButton(
            text = Res.string.receive,
            icon = Res.drawable.ic_receive,
            modifier = Modifier.constrainAs(receiveButton) {
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                top.linkTo(background.top, margin = 4.dp)
                bottom.linkTo(background.bottom, margin = 4.dp)
                start.linkTo(exchangeButton.end, margin = 4.dp)
                end.linkTo(background.end, margin = 4.dp)
            }
        )
    }
}

@Composable
private fun SendReceiveButton(
    text: StringResource,
    icon: DrawableResource,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(shapes.extraLarge)
            .clickable {}
            .padding(horizontal = 4.dp)
    ) {
        AppImage(
            image = icon,
            color = colors.text,
            modifier = Modifier.size(10.dp)
        )
        Text(
            text = stringResource(text),
            color = colors.text,
            style = typography.body1,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun ExchangeButton(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxHeight()
            .aspectRatio(1f)
            .clip(shapes.circle)
            .background(
                color = colors.accent,
                shape = shapes.circle
            )
            .clickable {}
    ) {
        AppImage(
            image = Res.drawable.ic_exchange,
            color = colors.text,
            modifier = Modifier.size(28.dp)
        )
    }
}