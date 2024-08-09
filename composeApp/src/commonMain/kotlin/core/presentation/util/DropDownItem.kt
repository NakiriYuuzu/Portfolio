package core.presentation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.stringResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.ui_show_more

data class DropDownItem(
    val icon: ImageVector,
    val title: (@Composable () -> Unit),
    val active: Boolean = false,
) {
    companion object {
        val settingsList = listOf(
            DropDownItem(
                icon = Icons.Outlined.Settings,
                title = {
                    Text(
                        text = stringResource(Res.string.ui_show_more),
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                active = true
            )
        )
    }
}