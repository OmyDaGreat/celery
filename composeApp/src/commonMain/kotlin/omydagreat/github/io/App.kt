package omydagreat.github.io

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
  MaterialTheme(colors = Global.theme) {
    Box(modifier = Modifier.background(Global.theme.background)) {
      when (Global.currentScreen) {
        is Screen.Home -> HomeScreen { screen -> Global.currentScreen = screen }
        is Screen.Details -> DetailsScreen { Global.currentScreen = Screen.Home }
      }
    }
  }
}
