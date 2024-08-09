package feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import core.presentation.components.PortfolioScaffold

@Composable
fun ProfileScreenRoot(
    onSettingClick: () -> Unit
) {
    ProfileScreen(onSettingClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onSettingClick: () -> Unit,
//    onAction: (ProfileAction) -> Unit
) {
    PortfolioScaffold(
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetContent = { Content(onSettingClick) }
    ) {

    }
}

@Composable
fun Content(
    onSettingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onSettingClick) {
            Icon(
                imageVector = Icons.TwoTone.Settings,
                contentDescription = null
            )
        }
    }
}