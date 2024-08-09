package core.util.extension

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalDensity

/**
 * Keep track of the keyboard state
 */
internal enum class KeyboardState {
    Opened,
    Closed
}

/**
 * Keyboard state as a composable
 * @return [State] of [KeyboardState]
 */
@Composable
internal fun keyboardVisibilityAsState(): State<KeyboardState> {
    return rememberUpdatedState(
        if (WindowInsets.ime.getBottom(LocalDensity.current) > 0) KeyboardState.Opened
        else KeyboardState.Closed
    )
}