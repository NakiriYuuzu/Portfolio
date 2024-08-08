import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import core.domain.model.DarkThemePreference
import core.presentation.theme.Theme
import feature.AppSettingProvider
import feature.setting.SettingViewModel
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
internal fun App() {
    KoinContext {
        val viewModel = koinViewModel<SettingViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        val navController = rememberNavController()

        AppSettingProvider(state = state) {
            Theme {
                NavHost(
                    navController = navController,
                    startDestination = Home
                ) {
                    composable<Home> {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = state.seedColor)
                        ) {
                            Text(text = "Current Platform: wasmJS!", style = MaterialTheme.typography.displayLarge)
                            Button(onClick = { navController.navigate(Setting) }) {
                                Text(text = "Go to Setting")
                            }
                        }
                    }
                    composable<Setting> {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Button(onClick = { navController.navigateUp() }) {
                                Text(text = "Go to Home")
                            }
                            Button(onClick = {
                                val randomColor = (0xFF000000..0xFFFFFFFF).random()
                                viewModel.onThemeColorChanged(randomColor)
                                println(randomColor)
                            }) {
                                Text(text = "Change Color!")
                            }

                            val darkTheme = if (state.darkTheme.isDarkTheme()) DarkThemePreference.OFF else DarkThemePreference.ON

                            Button(onClick = {
                                viewModel.onThemePreferenceChanged(darkTheme)
                            }) {
                                Text(text = "Change Theme!")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object Home
@Serializable
object Setting