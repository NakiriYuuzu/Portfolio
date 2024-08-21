package core.presentation.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

@Composable
fun PortfolioScaffold(
    modifier: Modifier = Modifier,
    gradient: Boolean = true,
    topAppBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topAppBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) { padding ->
        if (gradient) {
            PortfolioBackground(hasToolbar = true) {
                content(padding)
            }
        } else content(padding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioSheetScaffold(
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    sheetPeekHeight: Dp = BottomSheetDefaults.SheetPeekHeight,
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
    sheetShape: Shape = BottomSheetDefaults.ExpandedShape,
    sheetSwipeEnabled: Boolean = true,
    gradient: Boolean = true,
    modifier: Modifier = Modifier,
    topAppBar: @Composable () -> Unit = {},
    sheetContent: @Composable ColumnScope.() -> Unit,
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    content: @Composable (PaddingValues) -> Unit
) {
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = sheetPeekHeight,
        sheetMaxWidth = sheetMaxWidth,
        sheetShape = sheetShape,
        sheetSwipeEnabled = sheetSwipeEnabled,
        modifier = modifier,
        topBar = topAppBar,
        sheetContent = sheetContent,
        snackbarHost = snackbarHost
    ) { padding ->
        if (gradient) {
            PortfolioBackground(hasToolbar = true) {
                content(padding)
            }
        } else content(padding)
    }
}