package feature.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import core.presentation.components.PortfolioScaffold
import core.presentation.components.PortfolioSelectTextField
import core.presentation.components.PortfolioTopBar
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.setting_style_theme_desc
import portfolio.composeapp.generated.resources.setting_style_theme_title
import portfolio.composeapp.generated.resources.setting_style_title
import portfolio.composeapp.generated.resources.ui_show_more

@Composable
fun SettingScreenRoot(
    viewModel: SettingViewModel = koinViewModel<SettingViewModel>(),
    onBackClicked: () -> Unit
) {
    SettingScreen(
        state = viewModel.state.value,
        onAction = { action ->
            when (action) {
                SettingAction.OnBackClicked -> onBackClicked()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    state: SettingState,
    onAction: (SettingAction) -> Unit
) {
    PortfolioScaffold(
        scaffoldState = rememberBottomSheetScaffoldState(),
        topAppBar = {
            PortfolioTopBar(
                showBackButton = true,
                title = stringResource(Res.string.ui_show_more),
                onBackClick = { }
            )
        },
        sheetContent = { }
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(resource = Res.string.setting_style_title),
                    fontWeight = FontWeight.Bold,
                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                ) {
                    Column(modifier = Modifier.weight(0.6f)) {
                        Text(
                            text = stringResource(resource = Res.string.setting_style_theme_title),
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = MaterialTheme.typography.bodyMedium.fontStyle)
                        Text(
                            text = stringResource(resource = Res.string.setting_style_theme_desc),
                            fontStyle = MaterialTheme.typography.bodySmall.fontStyle)
                    }
//                    PortfolioSelectTextField(
//                        value = ,
//                        options = ThemeMode.entries.map { it.name },
//                        onValueChangedEvent = { value ->
//                            when (value) {
//
//                            }
//                        },
//                        modifier = Modifier.weight(0.4f)
//                    )
                }
                HorizontalDivider()
            }
        }
    }
}