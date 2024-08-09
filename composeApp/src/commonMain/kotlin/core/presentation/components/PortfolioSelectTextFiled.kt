package core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import core.util.extension.KeyboardState
import core.util.extension.keyboardVisibilityAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PortfolioSelectTextField(
value: String,
options: List<String>,
onValueChangedEvent: (String) -> Unit,
modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current
    val keyboardState by keyboardVisibilityAsState()
    var isFocused by remember { mutableStateOf(false) }

    LaunchedEffect(keyboardState) {
        if (keyboardState == KeyboardState.Closed) focusManager.clearFocus()
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        BasicTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onBackground),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
            decorationBox = { innerBox ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        innerBox()
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.rotate(if (expanded) 180f else 0f)
                    )
                }
            },
            modifier = Modifier
                .menuAnchor(
                    type = MenuAnchorType.PrimaryNotEditable,
                    enabled = true
                )
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .background(
                    if (isFocused) {
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                )
                .border(
                    width = 1.dp,
                    color = if (isFocused) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    shape = MaterialTheme.shapes.small
                )
                .padding(12.dp)
                .onFocusChanged { isFocused = it.isFocused }
        )
        MaterialTheme(
            colorScheme = MaterialTheme.colorScheme.copy(
                surface = MaterialTheme.colorScheme.surfaceContainer
            ),
            shapes = MaterialTheme.shapes.copy(
                extraSmall = MaterialTheme.shapes.medium.copy(
                    topStart = CornerSize(0.dp),
                    topEnd = CornerSize(0.dp)
                )
            )
        ) {
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainer,
                        shape = MaterialTheme.shapes.medium.copy(
                            topStart = CornerSize(0.dp),
                            topEnd = CornerSize(0.dp)
                        )
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        shape = MaterialTheme.shapes.medium.copy(
                            topStart = CornerSize(0.dp),
                            topEnd = CornerSize(0.dp)
                        )
                    )
            ) {
                options.forEach { option: String ->
                    DropdownMenuItem(
                        text = { Text(text = option) },
                        onClick = {
                            expanded = false
                            focusManager.clearFocus()
                            onValueChangedEvent(option)
                        }
                    )
                }
            }
        }
    }
}