package core.util.extension

import androidx.compose.ui.graphics.Color

/**
 * Convert a long color to a string color
 * e.g. 0xFF63A002 -> "63A002"
 * @return a string color
 */
internal fun Long.toStringColor(): String {
    return this.toString(16).padStart(8, '0').substring(2).uppercase()
}
/**
 * Convert a string color to a long color
 * e.g. "FF63A002" -> 0xFF63A002
 * @return a long color
 */
internal fun String.toLongColor(): Long {
    return this.toLong(16)
}
/**
 * To color need confirm the color is a color and length must be 8
 * @return a color
 */
internal fun String.toColor(): Color {
    return if (this.length == 8) Color(this.toLongColor()) else Color.Transparent
}
/**
 * Convert a long color to a color
 * @return a color
 */
internal fun Long.toColor(): Color {
    return Color(this)
}
/**
 * Convert a color to a string color
 * e.g. Color(0xFF63A002) -> "63A002"
 * @return a string color
 */
internal fun Color.toStringColor(): String {
    return this.value.toString(16).padStart(8, '0').substring(2).uppercase()
}