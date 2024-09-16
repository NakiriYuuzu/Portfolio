package feature.setting.validator

data class SettingValidatorState(
    val isColorLengthValid: Boolean = true,
    val isColorValid: Boolean = true
) {
    val isColor: Boolean
        get() = isColorLengthValid && isColorValid
}