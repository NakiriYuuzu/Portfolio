package core.util

import androidx.compose.runtime.compositionLocalOf
import com.materialkolor.DynamicMaterialThemeState
import core.presentation.theme.seed
import core.domain.model.DarkThemePreference

val LocalDarkTheme = compositionLocalOf { DarkThemePreference() }
val LocalSeedColor = compositionLocalOf { seed }
val LocalDynamicThemeState = compositionLocalOf<DynamicMaterialThemeState> { error("No theme state provided") }