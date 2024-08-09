package core.util.extension

import androidx.navigation.NavHostController

internal fun NavHostController.safePopBackStack(): Boolean {
    return if (this.currentBackStack.value.isNotEmpty()) {
        popBackStack()
        true
    } else {
        false
    }
}