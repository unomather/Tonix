package tonix.app.app_ui_small.navigation.screen.ui.pin_code.data

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.DrawableResource
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.*
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeIcon.Biometry
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeIcon.RemoveDigit
import tonix.app.resources.Res
import tonix.app.resources.ic_pin_biometry
import tonix.app.resources.ic_pin_remove_digit

@Immutable
sealed class PinCodeItem(
    open val value: Any
) {
    @Immutable
    data class PinCodeDigit(override val value: String): PinCodeItem(value)

    @Immutable
    sealed class PinCodeIcon(override val value: DrawableResource): PinCodeItem(value) {
        data object Biometry: PinCodeIcon(Res.drawable.ic_pin_biometry)
        data object RemoveDigit: PinCodeIcon(Res.drawable.ic_pin_remove_digit)
    }

    @Immutable
    data object EmptySpace: PinCodeItem("")
}

internal val pinCodeItems = listOf(
    PinCodeDigit("1"),
    PinCodeDigit("2"),
    PinCodeDigit("3"),
    PinCodeDigit("4"),
    PinCodeDigit("5"),
    PinCodeDigit("6"),
    PinCodeDigit("7"),
    PinCodeDigit("8"),
    PinCodeDigit("9"),
    Biometry,
    PinCodeDigit("0"),
    RemoveDigit
)