package omydagreat.github.io.Common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import omydagreat.github.io.Common.Util.Screen

object Global {
  var currentScreen by mutableStateOf<Screen>(Screen.Home)
  var theme by mutableStateOf(ThemeType.Mint)

  fun toggleTheme() {
    theme.isLightMode = !theme.isLightMode
  }
}
