package tonix.app.app_ui_small.navigation.screen.ui.pin_code.data

import androidx.compose.runtime.Immutable

@Immutable
sealed interface PinCodeDotsState {
    data object Default: PinCodeDotsState
    data object Success: PinCodeDotsState
    data class Error(val message: String): PinCodeDotsState
}