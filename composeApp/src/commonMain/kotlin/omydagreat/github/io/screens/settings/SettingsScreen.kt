package omydagreat.github.io.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import omydagreat.github.io.util.*

/**
 * Composable function for the Details screen.
 *
 * @param navi The Navigator instance for navigation.
 * @param homeRoute The route to navigate to the Home screen.
 */
@Composable
fun SettingsScreen(navi: Navigator, homeRoute: String) {
  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      HeadingSection()
      Spacer(modifier = Modifier.height(16.dp))
      HomeButton(navi, homeRoute)
      Spacer(modifier = Modifier.height(16.dp))
      ToggleThemeButton()
      Spacer(modifier = Modifier.height(16.dp))
      ThemeSelectionDropdown()
    }
  }
}

/**
 * Composable function for the heading section of the Details screen.
 */
@Composable
fun HeadingSection() {
  Heading4(text = "This is the Details Screen")
}

/**
 * Composable function for the Home button.
 *
 * @param navi The Navigator instance for navigation.
 * @param homeRoute The route to navigate to the Home screen.
 */
@Composable
fun HomeButton(navi: Navigator, homeRoute: String) {
  ThemedButton(onClick = { navi gate homeRoute }) {
    Body2("Go to Home")
  }
}

/**
 * Composable function for the Toggle Theme button.
 */
@Composable
fun ToggleThemeButton() {
  ThemedButton(onClick = { Global.toggleTheme() }) {
    Body2("Toggle ${"Light".takeIf { !Global.theme.isLightMode } ?: "Dark"} Mode")
  }
}

/**
 * Composable function for the Theme Selection dropdown menu.
 */
@Composable
fun ThemeSelectionDropdown() {
  var expanded by remember { mutableStateOf(false) }
  val themes = ThemeType.entries.toTypedArray()

  Box(contentAlignment = Alignment.Center) {
    ThemedButton(onClick = { expanded = true }) {
      Body2("Select Theme")
    }
    ThemedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
      themes.forEach { themeType ->
        DropdownMenuItem(onClick = {
          Global.theme = themeType
          expanded = false
        }) {
          Body2(text = themeType.name)
        }
      }
    }
  }
}
