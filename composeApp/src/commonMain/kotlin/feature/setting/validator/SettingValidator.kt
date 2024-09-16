package feature.setting.validator

class SettingValidator {
    fun validateColor(color: String): SettingValidatorState {
        return SettingValidatorState(
            isColorLengthValid = isColorLengthValid(color),
            isColorValid = isColorValid(color)
        )
    }

    private fun isColorLengthValid(color: String): Boolean {
        return color.length == 6
    }

    private fun isColorValid(color: String): Boolean {
        if (color.isEmpty()) return false
        return color.matches(Regex("^([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"))
    }
}