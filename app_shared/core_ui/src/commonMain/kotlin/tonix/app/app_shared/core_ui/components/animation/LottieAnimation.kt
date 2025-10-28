package tonix.app.app_shared.core_ui.components.animation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import tonix.app.app_shared.core_ui.components.animation.LottieAnimationPlayType.ENDLESSLY
import tonix.app.app_shared.core_ui.components.animation.LottieAnimationPlayType.ONCE
import tonix.app.resources.Res

enum class LottieAnimationPlayType {
    ONCE,
    ENDLESSLY
}

data class LottieAnimationSettings(
    val speed: Float = 1f,
    val isPlaying: Boolean = true,
    val playType: LottieAnimationPlayType = ONCE,
    val backgroundColor: Color = Color.Transparent
)

@Composable
fun LottieAnimation(
    filePath: String,
    animationSettings: LottieAnimationSettings,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/$filePath").decodeToString()
        )
    }
    Image(
        painter = rememberLottiePainter(
            composition = composition,
            speed = animationSettings.speed,
            isPlaying = animationSettings.isPlaying,
            iterations = if (animationSettings.playType == ENDLESSLY) Int.MAX_VALUE else 1
        ),
        contentDescription = "Lottie animation",
        modifier = modifier
    )
}