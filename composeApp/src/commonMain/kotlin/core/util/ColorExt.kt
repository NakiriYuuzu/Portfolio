package core.util

import androidx.compose.ui.graphics.Color

/**
 * Convert a long color to a string color
 * e.g. 0xFF63A002 -> "63A002"
 * @return a string color
 */
internal fun Long.toStringColor(): String {
    return this.toString(16).substring(2)
}

/**
 * Convert a string color to a long color
 * e.g. "63A002" -> 0x63A002
 * @return a long color
 */
internal fun String.toLongColor(): Long {
    return "FF$this".toLong(16)
}

/**
 * To color need confirm the color is a color and length must be 6
 * @return a color
 */
internal fun String.toColor(): Color {
    return if (this.length == 6) Color(this.toLongColor()) else Color.Transparent
}

/**
 * Convert a long color to a color
 * @return a color
 */
internal fun Long.toColor(): Color {
    return if (this.toString(16).length == 6) Color(this) else Color.Transparent
}