package omydagreat.github.io

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
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
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    when (currentScreen) {
      is Screen.Home -> HomeScreen(onNavigate = { currentScreen = it })
      is Screen.Details -> DetailsScreen(onBack = { currentScreen = Screen.Home })
    }
  }
}
