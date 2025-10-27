package tonix.app.app_ui_small.navigation.screen.ui.pin_code.data

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.DrawableResource
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.EmptySpace
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeDigit
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeIcon.Biometry
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeIcon.RemoveDigit
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode.CHECK
import tonix.app.resources.Res
import tonix.app.resources.ic_pin_biometry
import tonix.app.resources.ic_pin_remove_digit

@Immutable
sealed class PinCodeItem(
    open val value: Any
) {
    @Immutable
    data class PinCodeDigit(override val value: Int): PinCodeItem(value)

    @Immutable
    sealed class PinCodeIcon(override val value: DrawableResource): PinCodeItem(value) {
        data object Biometry: PinCodeIcon(Res.drawable.ic_pin_biometry)
        data object RemoveDigit: PinCodeIcon(Res.drawable.ic_pin_remove_digit)
    }

    @Immutable
    data object EmptySpace: PinCodeItem("")
}

internal fun getPinCodeItems(mode: PinCodeMode) = buildList {
    (1..9).forEach { digit ->
        add(PinCodeDigit(digit))
    }
    if (mode == CHECK) add(Biometry) else add(EmptySpace)
    add(PinCodeDigit(0))
    add(RemoveDigit)
}