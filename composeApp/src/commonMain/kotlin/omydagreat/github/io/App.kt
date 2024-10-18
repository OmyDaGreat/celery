package omydagreat.github.io

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import omydagreat.github.io.Common.Global
import omydagreat.github.io.Common.Util.Screen
import omydagreat.github.io.Details.DetailsScreen
import omydagreat.github.io.Home.HomeScreen
import omydagreat.github.io.Stocks.StocksScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Composable function that represents the main application.
 * It sets up the MaterialTheme and handles navigation between screens.
 */
@Composable
@Preview
fun App() = MaterialTheme(colors = Global.theme.colors) {
  Box(modifier = Modifier.background(Global.theme.colors.background)) {
    when (Global.currentScreen) {
      is Screen.Home -> HomeScreen { screen -> Global.currentScreen = screen }
      is Screen.Details -> DetailsScreen { Global.currentScreen = Screen.Home }
      is Screen.Stocks -> StocksScreen { Global.currentScreen = Screen.Home }
    }
  }
}