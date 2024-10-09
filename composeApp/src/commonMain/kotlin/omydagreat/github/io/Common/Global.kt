package omydagreat.github.io.Common

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object Global {
  var currentScreen by mutableStateOf<Screen>(Screen.Home)
  var isDarkMode by mutableStateOf<Boolean>(true)
  var darkTheme = darkColors(background = Color.Black, onBackground = Color.White)
  var lightTheme = lightColors(background = Color.White, onBackground = Color.Black)
  var theme by mutableStateOf<Colors>(if (isDarkMode) darkTheme else lightTheme)

  fun toggleTheme() {
    isDarkMode = !isDarkMode
    theme = if (isDarkMode) darkTheme else lightTheme
  }
}
