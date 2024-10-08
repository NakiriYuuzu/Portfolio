import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import core.navigation.NavRoute
import core.presentation.theme.Theme
import feature.AppSettingProvider
import feature.setting.SettingViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
internal fun App() {
    KoinContext {
        val viewModel = koinViewModel<SettingViewModel>()
        val state by viewModel.state.collectAsState()

        AppSettingProvider(state = state) {
            Theme {
               NavRoute(viewModel = viewModel)
            }
        }
    }
}