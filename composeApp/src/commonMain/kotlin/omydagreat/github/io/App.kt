package omydagreat.github.io

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import omydagreat.github.io.Common.Global
import omydagreat.github.io.Common.Screen
import omydagreat.github.io.Details.DetailsScreen
import omydagreat.github.io.Home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Composable function that represents the main application.
 * It sets up the MaterialTheme and handles navigation between screens.
 */
@Composable
@Preview
fun App() {
  MaterialTheme {
    when (Global.currentScreen) {
      is Screen.Home -> HomeScreen { screen -> Global.currentScreen = screen }
      is Screen.Details -> DetailsScreen { Global.currentScreen = Screen.Home }
    }
  }
}
