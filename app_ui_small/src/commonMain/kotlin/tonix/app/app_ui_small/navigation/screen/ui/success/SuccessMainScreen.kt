package tonix.app.app_ui_small.navigation.screen.ui.success

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import org.jetbrains.compose.resources.stringResource
import tonix.app.app_shared.core_ui.components.animation.KottieAnimationSettings
import tonix.app.app_shared.core_ui.components.animation.KottieAnimationView
import tonix.app.app_shared.core_ui.components.animation.KottieCompositionSpecType
import tonix.app.app_shared.core_ui.components.animation.kottieAnimationFile
import tonix.app.app_shared.core_ui.components.button.AppButton
import tonix.app.app_shared.core_ui.components.button.AppButtonState
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.resources.Res
import tonix.app.resources.`continue`
import tonix.app.resources.done
import tonix.app.resources.ic_done
import tonix.app.resources.wallet_created_success

@Composable
internal fun SuccessMainScreen(
    state: SuccessState,
    listener: SuccessListener?
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        val (icon, animation, title, description, button) = createRefs()
        createVerticalChain(
            icon,
            title,
            description,
            chainStyle = ChainStyle.Packed
        )
        Animation(
            modifier = Modifier.constrainAs(animation) {
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
                top.linkTo(parent.top)
                bottom.linkTo(icon.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Icon(
            modifier = Modifier.constrainAs(icon) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
        )
        Title(
            modifier = Modifier.constrainAs(title) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Description(
            modifier = Modifier.constrainAs(description) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(button.top)
            }
        )
        Button(
            modifier = Modifier.constrainAs(button) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Composable
private fun Animation(modifier: Modifier) {
    val file by kottieAnimationFile("anim_confetti.json")
    KottieAnimationView(
        type = KottieCompositionSpecType.File(file),
        animationSettings = KottieAnimationSettings(),
        modifier = modifier
    )
}

@Composable
private fun Icon(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(108.dp)
            .clip(shapes.circle)
            .background(colors.success)
    ) {
        AppImage(
            image = Res.drawable.ic_done,
            color = colors.text,
            modifier = Modifier.size(54.dp)
        )
    }
}

@Composable
private fun Title(modifier: Modifier) {
    Text(
        text = stringResource(Res.string.done),
        color = colors.text,
        style = typography.h1,
        modifier = modifier.padding(top = 16.dp)
    )
}

@Composable
private fun Description(modifier: Modifier) {
    Text(
        text = stringResource(Res.string.wallet_created_success),
        color = colors.text.copy(alpha = 0.5f),
        style = typography.h4.copy(fontWeight = FontWeight.Normal),
        textAlign = TextAlign.Center,
        modifier = modifier.padding(top = 10.dp, start = 32.dp, end = 32.dp)
    )
}

@Composable
private fun Button(modifier: Modifier) {
    AppButton(
        text = stringResource(Res.string.`continue`),
        state = AppButtonState.ACCENT,
        onClick = { },
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
            .fillMaxWidth()
            .height(56.dp)
    )
}