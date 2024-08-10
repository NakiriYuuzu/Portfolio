@file:OptIn(ExperimentalComposeUiApi::class)

package core.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import platform.CoreGraphics.CGRect
import platform.UIKit.UIScreen

@Composable
actual fun getScreenWidthDp(): Dp = LocalWindowInfo.current.containerSize.width.dp

@Composable
actual fun getScreenHeightDp(): Dp = LocalWindowInfo.current.containerSize.height.dp