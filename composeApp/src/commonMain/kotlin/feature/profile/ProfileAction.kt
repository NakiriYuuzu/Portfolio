package feature.profile

sealed interface ProfileAction {
    data object OnSettingClick: ProfileAction
}