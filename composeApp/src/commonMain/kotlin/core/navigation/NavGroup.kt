package core.navigation

import kotlinx.serialization.Serializable

@Serializable
object ProfileGroup {
    @Serializable
    object ProfileScreen
}

@Serializable
object PortfolioGroup {
    @Serializable
    object PortfolioScreen
}

@Serializable
object SettingGroup {
    @Serializable
    object SettingScreen
}